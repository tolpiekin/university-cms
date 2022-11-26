package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public String showStudentsList(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }
}
