package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.User;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.UserRepository;

import javax.transaction.Transactional;

public interface UserService {
    @Autowired
    void setUserRepository(UserRepository userRepository);

    User findByUsername(String username);

    @Transactional
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
