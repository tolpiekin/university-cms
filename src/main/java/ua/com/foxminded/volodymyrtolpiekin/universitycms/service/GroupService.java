package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.GroupDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Group;

import java.util.List;

public interface GroupService {
    Group addGroup(Group group);

    Group findById(Long id);

    List<Group> findAll();

    Group update(Group group);

    void deleteById(Long id);

    List<GroupDTO> getAll();

    GroupDTO createGroup(GroupDTO groupDTO);

    GroupDTO readById(Long groupId);

    GroupDTO update(GroupDTO groupDTO);
}
