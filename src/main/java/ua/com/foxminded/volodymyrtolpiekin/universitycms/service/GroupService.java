package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Group;

import java.util.List;

public interface GroupService {
    Group addGroup(Group group);

    Group findById(Long id);

    List<Group> findAll();

    Group update(Group group);

    void deleteById(Long id);
}
