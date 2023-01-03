package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.User;

public interface UserService {

    User getByUsername(String username);
    User create(User user);
}
