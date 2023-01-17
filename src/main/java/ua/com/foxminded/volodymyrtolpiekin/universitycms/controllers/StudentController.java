package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.StudentDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Student;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    private final ModelMapper mapper;

    public StudentController(StudentService studentService, ModelMapper mapper) {
        this.studentService = studentService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<StudentDTO> showStudentsList() {
        return studentService.readAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteById(studentId);
    }

    @GetMapping(path="{studentId}")
    public StudentDTO getStudent(@PathVariable("studentId") Long studentId) {
        return studentService.readById(studentId);
    }

    @PutMapping
    public void updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.update(mapper.map(studentDTO, Student.class));
    }
    
}
