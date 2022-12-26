package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.LessonRepository;

@Controller
public class LessonController {
    private final LessonRepository lessonRepository;

    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @GetMapping("/lessons")
    public String showLessonsList(Model model) {
        model.addAttribute("lessons", lessonRepository.findAll());
        return "lessons";
    }
}
