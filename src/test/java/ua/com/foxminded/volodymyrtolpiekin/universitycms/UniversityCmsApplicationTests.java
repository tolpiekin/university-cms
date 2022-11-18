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

import static org.mockito.ArgumentMatchers.any;
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
		group.setId(1l);
		group.setName("First group");
		Student student = new Student();
		student.setId(1l);
		student.setName("Taras Shevchenko");
		student.setGroup(group);
		doReturn(Optional.of(student)).when(studentRepository).findById(1l);
		Student returnedStudent = studentService.findById(1l);
		Assertions.assertNotNull(returnedStudent, "Student was found");
		Assertions.assertSame(returnedStudent, student, "The student returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findStudentById Not Found")
	void testFindStudentByIdNotFound() {
		doReturn(Optional.empty()).when(studentRepository).findById(1l);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> studentService.findById(1l));

		Assertions.assertEquals("404 NOT_FOUND \"Student Not Found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllStudents")
	void testGetAllStudent() {
		Group group = new Group();
		group.setId(1l);
		group.setName("Test group");
		Student student1 = new Student();
		student1.setId(1l);
		student1.setName("John Doe");
		student1.setGroup(group);
		Student student2 = new Student();
		student2.setId(2l);
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
		student.setId(1l);
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
		group.setId(1l);
		group.setName("First group");

		Course course = new Course();
		course.setId(1l);
		course.setName("Main course");
		course.setGroup(group);

		doReturn(Optional.of(course)).when(courseRepository).findById(1l);
		Course returnedCourse = courseService.findById(1l);
		Assertions.assertNotNull(returnedCourse, "Course was found");
		Assertions.assertSame(returnedCourse, course, "The course returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findCourseById Not Found")
	void testFindCourseByIdNotFound() {
		doReturn(Optional.empty()).when(courseRepository).findById(1l);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> courseService.findById(1l));

		Assertions.assertEquals("404 NOT_FOUND \"Course not found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllCourses")
	void testGetAllCourses() {

		Group group = new Group();
		group.setId(1l);
		group.setName("First group");

		Course course1 = new Course();
		course1.setId(1l);
		course1.setName("Main course");
		course1.setGroup(group);

		Course course2 = new Course();
		course2.setId(1l);
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
		group.setId(1l);
		group.setName("First group");

		Course course = new Course();
		course.setId(1l);
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
		dayOfWeek.setId(1l);

		doReturn(Optional.of(dayOfWeek)).when(dayOfWeekRepository).findById(1l);
		DayOfWeek returnedDayOfWeek = dayOfWeekService.findById(1l);
		Assertions.assertNotNull(returnedDayOfWeek, "DayOfWeek was found");
		Assertions.assertSame(returnedDayOfWeek, dayOfWeek, "The dayOfWeek returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findDayOfWeekById Not Found")
	void testFindDayOfWeekByIdNotFound() {
		doReturn(Optional.empty()).when(dayOfWeekRepository).findById(1l);

		ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class,
				() -> dayOfWeekService.findById(1l));

		Assertions.assertEquals("404 NOT_FOUND \"DayOfWeek not found\"", responseStatusException.getMessage());
	}

	@Test
	@DisplayName("Test getAllDayOfWeeks")
	void testGetAllDayOfWeeks() {

		DayOfWeek dayOfWeek1 = new DayOfWeek();
		dayOfWeek1.setId(1l);

		DayOfWeek dayOfWeek2 = new DayOfWeek();
		dayOfWeek2.setId(1l);

		doReturn(Arrays.asList(dayOfWeek1, dayOfWeek2)).when(dayOfWeekRepository).findAll();
		List<DayOfWeek> dayOfWeeks = dayOfWeekService.findAll();
		Assertions.assertEquals(2, dayOfWeeks.size(), "getAll should return 2 dayOfWeeks");
	}

	@Test
	@DisplayName("Test add dayOfWeek")
	void testAddDayOfWeek() {

		DayOfWeek dayOfWeek = new DayOfWeek();
		dayOfWeek.setId(1l);

		doReturn(dayOfWeek).when(dayOfWeekRepository).save(dayOfWeek);
		DayOfWeek returnedDayOfWeek = dayOfWeekService.addDayOfWeek(dayOfWeek);
		Assertions.assertNotNull(returnedDayOfWeek, "The saved dayOfWeek should not be null");
		Assertions.assertEquals(returnedDayOfWeek, dayOfWeek, "Should be the same dayOfWeek");
	}
}
