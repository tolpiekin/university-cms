package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);

    Course findById(Long id);

    List<Course> findAll();

    Course update(Course course);

    void deleteById(Long id);

    Course update(Long courseId, String name, Long groupId, Long tutorId);
}
