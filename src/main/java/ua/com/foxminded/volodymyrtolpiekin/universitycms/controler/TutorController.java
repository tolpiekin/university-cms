package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TutorRepository;

@Controller
public class TutorController {
    private final TutorRepository tutorRepository;

    public TutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @GetMapping("/tutors")
    public String showTutors(Model model) {
        model.addAttribute("tutors", tutorRepository.findAll());
        return "tutors";
    }
}
