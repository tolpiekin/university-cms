package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<Course> addCourse(Course course){
        return Optional.of(courseRepository.save(course));
    }

    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public Optional<Course> update(Long id, Course course){
        course.setId(id);
        courseRepository.save(course);
        return courseRepository.findById(id);
    }

    public void deleteById(Long id){
        courseRepository.deleteById(id);
    }
}
