package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
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
        findById(id);
        courseRepository.deleteById(id);
    }
}
