package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.configs.JwtUtils;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.payload.request.LoginRequest;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.payload.request.SignupRequest;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl.UserServiceImpl;

import javax.validation.Valid;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserServiceImpl userService;

    private final JwtUtils jwtUtils;

    public AuthController(UserServiceImpl userService, JwtUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return jwtUtils.getJwtResponseResponseEntity(loginRequest);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        return userService.signUpNewUser(signupRequest);
    }
}
