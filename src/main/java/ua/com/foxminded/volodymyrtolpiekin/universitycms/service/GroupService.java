package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Group;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group addGroup(Group group){
        return groupRepository.save(group);
    }

    public Optional<Group> findById(Long id){
        try {
            return Optional.of(groupRepository.findById(id)).orElseThrow(()->new GroupNotFoundException(id));
        }
        catch (GroupNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group Not Found", exc);
        }
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
        try {
            Optional.of(findById(id)).orElseThrow(()->new GroupNotFoundException(id));
        }
        catch (GroupNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group Not Found", exc);
        }
        groupRepository.deleteById(id);
    }
}
