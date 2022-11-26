package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.GroupRepository;

@Controller
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/groups")
    public String showGroupsList(Model model) {
        model.addAttribute("groups", groupRepository.findAll());
        return "groups";
    }
}
