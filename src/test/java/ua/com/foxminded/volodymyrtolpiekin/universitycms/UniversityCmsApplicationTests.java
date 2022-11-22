package ua.com.foxminded.volodymyrtolpiekin.universitycms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
class UniversityCmsApplicationTests {

	@Autowired
	CourseService courseService;

	@Autowired
	DayOfWeekService dayOfWeekService;

	@Autowired
	StudentService studentService;

	@Autowired
	GroupService groupService;

	@Autowired
	LessonService lessonService;

	@Autowired
	TimetableService timetableService;

	@Autowired
	TopicService topicService;

	@Autowired
	TutorService tutorService;

	@MockBean
	CourseRepository courseRepository;

	@MockBean
	DayOfWeekRepository dayOfWeekRepository;

	@MockBean
	GroupRepository groupRepository;

	@MockBean
	LessonRepository lessonRepository;

	@MockBean
	StudentRepository studentRepository;

	@MockBean
	TimetableRepository timetableRepository;

	@MockBean
	TopicRepository topicRepository;

	@MockBean
	TutorRepository tutorRepository;

	@Test
	@DisplayName("Test findStudentById Success")
	void testFindStudentById() {
		Group group = new Group();
		group.setId(1L);
		group.setName("First group");
		Student student = new Student();
		student.setId(1L);
		student.setName("Taras Shevchenko");
		student.setGroup(group);
		doReturn(Optional.of(student)).when(studentRepository).findById(1L);
		Student returnedStudent = studentService.findById(1L);
		Assertions.assertNotNull(returnedStudent, "Student was found");
		Assertions.assertSame(returnedStudent, student, "The student returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findStudentById Not Found")
	void testFindStudentByIdNotFound() {
		doReturn(Optional.empty()).when(studentRepository).findById(1L);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> studentService.findById(1L));

		Assertions.assertEquals("404 NOT_FOUND \"Student Not Found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllStudents")
	void testGetAllStudent() {
		Group group = new Group();
		group.setId(1L);
		group.setName("Test group");
		Student student1 = new Student();
		student1.setId(1L);
		student1.setName("John Doe");
		student1.setGroup(group);
		Student student2 = new Student();
		student2.setId(2L);
		student2.setName("Boris Jonson");
		student2.setGroup(group);
		doReturn(Arrays.asList(student1, student2)).when(studentRepository).findAll();
		List<Student> students = studentService.findAll();
		Assertions.assertEquals(2, students.size(), "getAll should return 2 students");
	}

	@Test
	@DisplayName("Test add student")
	void testAddStudent() {
		Student student = new Student();
		student.setId(1L);
		student.setName("John Doe");

		doReturn(student).when(studentRepository).save(student);
		Student returnedStudent = studentService.addStudent(student);
		Assertions.assertNotNull(returnedStudent, "The saved student should not be null");
		Assertions.assertEquals(returnedStudent, student, "Should be the same student");
	}

	@Test
	@DisplayName("Test findCourseById Success")
	void testFindCourseById() {

		Group group = new Group();
		group.setId(1L);
		group.setName("First group");

		Course course = new Course();
		course.setId(1L);
		course.setName("Main course");
		course.setGroup(group);

		doReturn(Optional.of(course)).when(courseRepository).findById(1L);
		Course returnedCourse = courseService.findById(1L);
		Assertions.assertNotNull(returnedCourse, "Course was found");
		Assertions.assertSame(returnedCourse, course, "The course returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findCourseById Not Found")
	void testFindCourseByIdNotFound() {
		doReturn(Optional.empty()).when(courseRepository).findById(1L);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> courseService.findById(1L));

		Assertions.assertEquals("404 NOT_FOUND \"Course not found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllCourses")
	void testGetAllCourses() {

		Group group = new Group();
		group.setId(1L);
		group.setName("First group");

		Course course1 = new Course();
		course1.setId(1L);
		course1.setName("Main course");
		course1.setGroup(group);

		Course course2 = new Course();
		course2.setId(1L);
		course2.setName("Another course");
		course2.setGroup(group);

		doReturn(Arrays.asList(course1, course2)).when(courseRepository).findAll();
		List<Course> courses = courseService.findAll();
		Assertions.assertEquals(2, courses.size(), "getAll should return 2 courses");
	}

	@Test
	@DisplayName("Test add course")
	void testAddCourse() {

		Group group = new Group();
		group.setId(1L);
		group.setName("First group");

		Course course = new Course();
		course.setId(1L);
		course.setName("Main course");
		course.setGroup(group);

		doReturn(course).when(courseRepository).save(course);
		Course returnedCourse = courseService.addCourse(course);
		Assertions.assertNotNull(returnedCourse, "The saved course should not be null");
		Assertions.assertEquals(returnedCourse, course, "Should be the same course");
	}

	@Test
	@DisplayName("Test findDayOfWeekById Success")
	void testFindDayOfWeekById() {

		DayOfWeek dayOfWeek = new DayOfWeek();
		dayOfWeek.setId(1L);

		doReturn(Optional.of(dayOfWeek)).when(dayOfWeekRepository).findById(1L);
		DayOfWeek returnedDayOfWeek = dayOfWeekService.findById(1L);
		Assertions.assertNotNull(returnedDayOfWeek, "DayOfWeek was found");
		Assertions.assertSame(returnedDayOfWeek, dayOfWeek, "The dayOfWeek returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findDayOfWeekById Not Found")
	void testFindDayOfWeekByIdNotFound() {
		doReturn(Optional.empty()).when(dayOfWeekRepository).findById(1L);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> dayOfWeekService.findById(1L));

		Assertions.assertEquals("404 NOT_FOUND \"DayOfWeek not found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllDayOfWeeks")
	void testGetAllDayOfWeeks() {

		DayOfWeek dayOfWeek1 = new DayOfWeek();
		dayOfWeek1.setId(1L);

		DayOfWeek dayOfWeek2 = new DayOfWeek();
		dayOfWeek2.setId(1L);

		doReturn(Arrays.asList(dayOfWeek1, dayOfWeek2)).when(dayOfWeekRepository).findAll();
		List<DayOfWeek> dayOfWeeks = dayOfWeekService.findAll();
		Assertions.assertEquals(2, dayOfWeeks.size(), "getAll should return 2 dayOfWeeks");
	}

	@Test
	@DisplayName("Test add dayOfWeek")
	void testAddDayOfWeek() {

		DayOfWeek dayOfWeek = new DayOfWeek();
		dayOfWeek.setId(1L);

		doReturn(dayOfWeek).when(dayOfWeekRepository).save(dayOfWeek);
		DayOfWeek returnedDayOfWeek = dayOfWeekService.addDayOfWeek(dayOfWeek);
		Assertions.assertNotNull(returnedDayOfWeek, "The saved dayOfWeek should not be null");
		Assertions.assertEquals(returnedDayOfWeek, dayOfWeek, "Should be the same dayOfWeek");
	}

	@Test
	@DisplayName("Test findGroupById Success")
	void testFindGroupById() {

		Group group = new Group();
		group.setId(1L);
		group.setName("First group");

		doReturn(Optional.of(group)).when(groupRepository).findById(1L);
		Group returnedGroup = groupService.findById(1L);
		Assertions.assertNotNull(returnedGroup, "Group was found");
		Assertions.assertSame(returnedGroup, group, "The group returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findGroupById Not Found")
	void testFindGroupByIdNotFound() {
		doReturn(Optional.empty()).when(groupRepository).findById(1L);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> groupService.findById(1L));

		Assertions.assertEquals("404 NOT_FOUND \"Group Not Found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllGroups")
	void testGetAllGroups() {

		Group group1 = new Group();
		group1.setId(1L);
		group1.setName("First group");

		Group group2 = new Group();
		group2.setId(2L);
		group2.setName("Second group");

		doReturn(Arrays.asList(group1, group2)).when(groupRepository).findAll();
		List<Group> groups = groupService.findAll();
		Assertions.assertEquals(2, groups.size(), "getAll should return 2 groups");
	}

	@Test
	@DisplayName("Test add group")
	void testAddGroup() {

		Group group = new Group();
		group.setId(1L);
		group.setName("First group");

		doReturn(group).when(groupRepository).save(group);
		Group returnedGroup = groupService.addGroup(group);
		Assertions.assertNotNull(returnedGroup, "The saved group should not be null");
		Assertions.assertEquals(returnedGroup, group, "Should be the same group");
	}

	@Test
	@DisplayName("Test findLessonById Success")
	void testFindLessonById() {

		Lesson lesson = new Lesson();
		lesson.setId(1L);

		doReturn(Optional.of(lesson)).when(lessonRepository).findById(1L);
		Lesson returnedLesson = lessonService.findById(1L);
		Assertions.assertNotNull(returnedLesson, "Lesson was found");
		Assertions.assertSame(returnedLesson, lesson, "The lesson returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findLessonById Not Found")
	void testFindLessonByIdNotFound() {
		doReturn(Optional.empty()).when(lessonRepository).findById(1L);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> lessonService.findById(1L));

		Assertions.assertEquals("404 NOT_FOUND \"Lesson Not Found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllLessons")
	void testGetAllLessons() {

		Lesson lesson1 = new Lesson();
		lesson1.setId(1L);

		Lesson lesson2 = new Lesson();
		lesson2.setId(2L);

		doReturn(Arrays.asList(lesson1, lesson2)).when(lessonRepository).findAll();
		List<Lesson> lessons = lessonService.findAll();
		Assertions.assertEquals(2, lessons.size(), "getAll should return 2 lessons");
	}

	@Test
	@DisplayName("Test add lesson")
	void testAddLesson() {

		Lesson lesson = new Lesson();
		lesson.setId(1L);

		doReturn(lesson).when(lessonRepository).save(lesson);
		Lesson returnedLesson = lessonService.addLesson(lesson);
		Assertions.assertNotNull(returnedLesson, "The saved lesson should not be null");
		Assertions.assertEquals(returnedLesson, lesson, "Should be the same lesson");
	}

	@Test
	@DisplayName("Test findTimetableById Success")
	void testFindTimetableById() {

		Timetable timetable = new Timetable();
		timetable.setId(1L);

		doReturn(Optional.of(timetable)).when(timetableRepository).findById(1L);
		Timetable returnedTimetable = timetableService.findById(1L);
		Assertions.assertNotNull(returnedTimetable, "Timetable was found");
		Assertions.assertSame(returnedTimetable, timetable, "The timetable returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findTimetableById Not Found")
	void testFindTimetableByIdNotFound() {
		doReturn(Optional.empty()).when(timetableRepository).findById(1L);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> timetableService.findById(1L));

		Assertions.assertEquals("404 NOT_FOUND \"Timetable Not Found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllTimetables")
	void testGetAllTimetables() {

		Timetable timetable1 = new Timetable();
		timetable1.setId(1L);

		Timetable timetable2 = new Timetable();
		timetable2.setId(2L);

		doReturn(Arrays.asList(timetable1, timetable2)).when(timetableRepository).findAll();
		List<Timetable> timetables = timetableService.findAll();
		Assertions.assertEquals(2, timetables.size(), "getAll should return 2 timetables");
	}

	@Test
	@DisplayName("Test add timetable")
	void testAddTimetable() {

		Timetable timetable = new Timetable();
		timetable.setId(1L);

		doReturn(timetable).when(timetableRepository).save(timetable);
		Timetable returnedTimetable = timetableService.addTimetable(timetable);
		Assertions.assertNotNull(returnedTimetable, "The saved timetable should not be null");
		Assertions.assertEquals(returnedTimetable, timetable, "Should be the same timetable");
	}

	@Test
	@DisplayName("Test findTopicById Success")
	void testFindTopicById() {

		Topic topic = new Topic();
		topic.setId(1L);

		doReturn(Optional.of(topic)).when(topicRepository).findById(1L);
		Topic returnedTopic = topicService.findById(1L);
		Assertions.assertNotNull(returnedTopic, "Topic was found");
		Assertions.assertSame(returnedTopic, topic, "The topic returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findTopicById Not Found")
	void testFindTopicByIdNotFound() {
		doReturn(Optional.empty()).when(topicRepository).findById(1L);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> topicService.findById(1L));

		Assertions.assertEquals("404 NOT_FOUND \"Topic Not Found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllTopics")
	void testGetAllTopics() {

		Topic topic1 = new Topic();
		topic1.setId(1L);

		Topic topic2 = new Topic();
		topic2.setId(2L);

		doReturn(Arrays.asList(topic1, topic2)).when(topicRepository).findAll();
		List<Topic> topics = topicService.findAll();
		Assertions.assertEquals(2, topics.size(), "getAll should return 2 topics");
	}

	@Test
	@DisplayName("Test add topic")
	void testAddTopic() {

		Topic topic = new Topic();
		topic.setId(1L);

		doReturn(topic).when(topicRepository).save(topic);
		Topic returnedTopic = topicService.addTopic(topic);
		Assertions.assertNotNull(returnedTopic, "The saved topic should not be null");
		Assertions.assertEquals(returnedTopic, topic, "Should be the same topic");
	}

	@Test
	@DisplayName("Test findTutorById Success")
	void testFindTutorById() {

		Tutor tutor = new Tutor();
		tutor.setId(1L);

		doReturn(Optional.of(tutor)).when(tutorRepository).findById(1L);
		Tutor returnedTutor = tutorService.findById(1L);
		Assertions.assertNotNull(returnedTutor, "Tutor was found");
		Assertions.assertSame(returnedTutor, tutor, "The tutor returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findTutorById Not Found")
	void testFindTutorByIdNotFound() {
		doReturn(Optional.empty()).when(tutorRepository).findById(1L);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> tutorService.findById(1L));

		Assertions.assertEquals("404 NOT_FOUND \"Tutor Not Found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllTutors")
	void testGetAllTutors() {

		Tutor tutor1 = new Tutor();
		tutor1.setId(1L);

		Tutor tutor2 = new Tutor();
		tutor2.setId(2L);

		doReturn(Arrays.asList(tutor1, tutor2)).when(tutorRepository).findAll();
		List<Tutor> tutors = tutorService.findAll();
		Assertions.assertEquals(2, tutors.size(), "getAll should return 2 tutors");
	}

	@Test
	@DisplayName("Test add tutor")
	void testAddTutor() {

		Tutor tutor = new Tutor();
		tutor.setId(1L);

		doReturn(tutor).when(tutorRepository).save(tutor);
		Tutor returnedTutor = tutorService.addTutor(tutor);
		Assertions.assertNotNull(returnedTutor, "The saved tutor should not be null");
		Assertions.assertEquals(returnedTutor, tutor, "Should be the same tutor");
	}
}
