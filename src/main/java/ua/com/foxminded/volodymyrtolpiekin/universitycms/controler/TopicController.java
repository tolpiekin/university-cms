package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TopicRepository;

@Controller
public class TopicController {

    @Autowired
    TopicRepository topicRepository;

    @GetMapping("/topics")
    public String showTopicsList(Model model) {
        model.addAttribute("topics", topicRepository.findAll());
        return "topics";
    }
}
