package ua.com.foxminded.volodymyrtolpiekin.universitycms.repository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "admin@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "student@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_STUDENT"))
            ),
            new User(
                    "teacher@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_TEACHER"))
            ),
            new User(
                    "stuff@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_STUFF"))
            )
    );

    public UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
    }

    public List<UserDetails> findAll() {
        return APPLICATION_USERS;
    }
}
