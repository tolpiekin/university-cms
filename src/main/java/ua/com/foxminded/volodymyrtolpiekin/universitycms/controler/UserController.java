package ua.com.foxminded.volodymyrtolpiekin.universitycms.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get")
    public List<UserDetails> getUser() {
        return userRepository.findAll();
    }
}
