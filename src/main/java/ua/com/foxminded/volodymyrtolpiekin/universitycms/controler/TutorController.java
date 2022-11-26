package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Tutor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TutorRepository;

@Controller
public class TutorController {

    @Autowired
    TutorRepository tutorRepository;

    @GetMapping("/tutors")
    public String showTutors(Model model) {
        model.addAttribute("tutors", tutorRepository.findAll());
        return "tutors";
    }
}
