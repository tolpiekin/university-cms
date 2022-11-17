package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.CourseRepository;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public Optional<Course> findById(Long id){
        return Optional.of(courseRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not found"));
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
        try{
            Optional.of(findById(id)).orElseThrow(()-> new CourseNotFoundException(id));
        }
        catch (CourseNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course Not Found", exc);
        }
        courseRepository.deleteById(id);
    }
}
