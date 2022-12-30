package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.ERole;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Role;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.User;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.payload.request.SignupRequest;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.payload.response.MessageResponse;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.RoleRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.UserRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public boolean ifUsernameExists (SignupRequest signupRequest) {
        return userRepository.existsByUsername(signupRequest.getUsername());
    }

    public boolean ifEmailExists(SignupRequest signupRequest) {
        return userRepository.existsByEmail(signupRequest.getEmail());
    }

    public Set<Role> setRoles(Set<String> strRoles) {
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role studentRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(studentRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "stuff":
                        Role stuffRole = roleRepository.findByName(ERole.ROLE_STUFF)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(stuffRole);

                        break;
                    case "teacher":
                        Role teacherRole = roleRepository.findByName(ERole.ROLE_TEACHER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(teacherRole);

                        break;

                    default:
                        Role studentRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(studentRole);
                }
            });
        }
        return roles;
    }

    public ResponseEntity<?> signUpNewUser (SignupRequest signupRequest){

        if (ifUsernameExists(signupRequest)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (ifEmailExists(signupRequest)) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()));
        user.setRoles(setRoles(signupRequest.getRole()));
        create(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }
}
