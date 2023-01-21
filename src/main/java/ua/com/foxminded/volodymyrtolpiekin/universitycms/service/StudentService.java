package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.StudentDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    Student findById(Long id);

    List<Student> findAll();

    Student update(Student student);

    void deleteById(Long id);

    List<StudentDTO> getAll();

    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO getById(Long studentId);

    StudentDTO update(StudentDTO studentDTO);
}
