package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Group;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.GroupRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group addGroup(Group group){
        return groupRepository.save(group);
    }

    @Override
    public Group findById(Long id){
        return groupRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Group Not Found"));
    }

    @Override
    public List<Group> findAll(){
        return groupRepository.findAll();
    }

    @Override
    public Group update(Group group){
        return groupRepository.save(group);
    }

    @Override
    public void deleteById(Long id){
        findById(id);
        groupRepository.deleteById(id);
    }
}
