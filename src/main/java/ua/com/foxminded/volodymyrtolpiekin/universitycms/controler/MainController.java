package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(Principal principal) {
        return "secured part of web service: " + principal.getName();
    }

    @GetMapping("/admin")
    public String pageForAdmins(Principal principal) {
        return "admin page for admin: " + principal.getName();
    }
}
