package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.CourseDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);

    Course findById(Long id);

    List<Course> findAll();

    Course update(Course course);

    void deleteById(Long id);

    List<CourseDTO> getAll();

    CourseDTO createCourse(CourseDTO courseDTO);

    CourseDTO getById(Long courseId);

    CourseDTO update(CourseDTO courseDTO);
}
