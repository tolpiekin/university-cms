package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.UserRepository;

@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("api/admin/users")
    public String showUsersList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
}
