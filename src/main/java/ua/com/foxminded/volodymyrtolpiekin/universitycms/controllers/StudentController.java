package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.StudentDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> showStudentsList() {
        return studentService.readAll();
    }
}
