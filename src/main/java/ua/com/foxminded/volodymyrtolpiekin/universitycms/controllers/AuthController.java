package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.configs.JwtUtils;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.ERole;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Role;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.User;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.payload.request.LoginRequest;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.payload.request.SignupRequest;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.payload.response.MessageResponse;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.RoleRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.UserRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.UserDetailsServiceImpl;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final UserDetailsServiceImpl userDetailsService;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, UserDetailsServiceImpl userDetailsService, RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return jwtUtils.getJwtResponseResponseEntity(loginRequest);
    }



    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        if (userDetailsService.ifUsernameExists(signupRequest)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userDetailsService.ifEmailExists(signupRequest)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        userDetailsService.signUpNewUser(signupRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
