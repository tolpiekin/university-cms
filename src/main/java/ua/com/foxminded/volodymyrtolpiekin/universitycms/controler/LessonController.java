package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.LessonRepository;

@Controller
public class LessonController {

    @Autowired
    LessonRepository lessonRepository;

    @GetMapping("/lessons")
    public String showLessonsList(Model model) {
        model.addAttribute("lessons", lessonRepository.findAll());
        return "lessons";
    }
}
