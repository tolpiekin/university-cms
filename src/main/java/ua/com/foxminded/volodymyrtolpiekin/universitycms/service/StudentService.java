package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    Student findById(Long id);

    Student findByUserId(Long userId);

    List<Student> findAll();

    Student update(Student student);

    void deleteById(Long id);
}
