package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.exceptions.CourseNotFoundException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.CourseRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.GroupService;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.CourseService;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.TutorService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final GroupService groupService;
    private final TutorService tutorService;

    public CourseServiceImpl(CourseRepository courseRepository, GroupService groupService, TutorService tutorService) {
        this.courseRepository = courseRepository;
        this.groupService = groupService;
        this.tutorService = tutorService;
    }

    @Override
    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public Course findById(Long id){
        return courseRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not found"));
    }

    @Override
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    @Override
    public Course update(Course course){
        Long courseId = course.getId();
        Course newCourse = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        if (course.getName() != null && !course.getName().equals(newCourse.getName()))
            newCourse.setName(course.getName());
        if (course.getGroup() != null && !course.getGroup().equals(newCourse.getGroup()))
            newCourse.setGroup(course.getGroup());
        if (course.getTutor() != null && !course.getTutor().equals(newCourse.getTutor()))
            newCourse.setTutor(course.getTutor());
        return courseRepository.save(newCourse);
    }

    @Override
    public void deleteById(Long id){
        Course course = findById(id);
        course.getTopics().forEach(t -> t.setCourse(null));
        course.getLessons().forEach(l -> l.setCourse(null));
        courseRepository.deleteById(id);
    }
}
