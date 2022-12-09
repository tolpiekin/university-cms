package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Student;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Tutor;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.User;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.StudentService;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.TutorService;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.UserService;

import java.security.Principal;

@Controller
public class MainController {
    private final UserService userService;
    private final StudentService studentService;
    private final TutorService tutorService;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    public MainController(UserService userService, StudentService studentService, TutorService tutorService) {
        this.userService = userService;
        this.studentService = studentService;
        this.tutorService = tutorService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/authenticated")
    public @ResponseBody String pageForAuthenticatedUsers(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return String.format("You logged in as user: %s, email: %s", user.getUsername(), user.getEmail());
    }

    @GetMapping("/welcome")
    public String pageForReadProfile(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        String message;
        if (user.getRoles().contains("ROLE_ADMIN")){
            message = String.format("You logged in as administrator");
        } else if(user.getRoles().contains("ROLE_STUDENT")) {
            Student student = studentService.findByUserId(user.getId());
            message = String.format("You logged in as a student, username: %s, name: %s", user.getUsername(), student.getName());
        } else if(user.getRoles().contains("ROLE_TEACHER")) {
            Tutor tutor = tutorService.findByUserId(user.getId());
            message = String.format("You logged in as a tutor, username: %s, name: %s", user.getUsername(), tutor.getName());
        } else if(user.getRoles().contains("ROLE_STUFF")){
            message = "You logged in as a Stuff.";
        } else {
            message = "You are user without any roles";
        }
        model.addAttribute("message", message);
        return "welcome";
    }

    @GetMapping("/admin")
    public @ResponseBody String pageOnlyForAdmins(Principal principal) {
        return "admin page for admin: " + principal.getName();
    }
}
