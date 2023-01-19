package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.StudentDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDTO> showStudentsList() {
        return studentService.getAll();
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
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.update(studentDTO);
    }

}
