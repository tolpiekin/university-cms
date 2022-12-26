package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.GroupRepository;

@Controller
public class GroupController {
    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    public String showGroupsList(Model model) {
        model.addAttribute("groups", groupRepository.findAll());
        return "groups";
    }
}
