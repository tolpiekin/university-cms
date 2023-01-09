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
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id){
        if (courseRepository.existsById(id)) {
            Course course = findById(id);
            course.getTopics().forEach(t -> t.setCourse(null));
            course.getLessons().forEach(l -> l.setCourse(null));
            courseRepository.deleteById(id);
        }
    }
}
