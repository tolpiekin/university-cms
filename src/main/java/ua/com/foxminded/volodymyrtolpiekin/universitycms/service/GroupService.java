package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Group;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Optional<Group> addGroup(Group group){
        return Optional.of(groupRepository.save(group));
    }

    public Optional<Group> findById(Long id){
        return groupRepository.findById(id);
    }

    public List<Group> findAll(){
        return groupRepository.findAll();
    }

    public Optional<Group> update(Long id, Group group){
        group.setId(id);
        groupRepository.save(group);
        return groupRepository.findById(id);
    }

    public void deleteById(Long id){
        groupRepository.deleteById(id);
    }
}
