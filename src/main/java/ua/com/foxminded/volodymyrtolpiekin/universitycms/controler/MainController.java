package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.User;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.UserService;

import java.security.Principal;

@Controller
public class MainController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/authenticated")
    public @ResponseBody String pageForAuthenticatedUsers(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return String.format("secured part of web service: %s, email: %s", user.getUsername(), user.getEmail());
    }

    @GetMapping("/read_profile")
    public @ResponseBody String pageForReadProfile() {
        return "read profile page";
    }

    @GetMapping("/admin")
    public @ResponseBody String pageOnlyForAdmins(Principal principal) {
        return "admin page for admin: " + principal.getName();
    }
}
