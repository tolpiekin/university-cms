package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TopicRepository;

@Controller
public class TopicController {
    private final TopicRepository topicRepository;

    public TopicController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @GetMapping("/topics")
    public String showTopicsList(Model model) {
        model.addAttribute("topics", topicRepository.findAll());
        return "topics";
    }
}
