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
        return Optional.of(groupRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Group Not Found"));
    }

    public List<Group> findAll(){
        return groupRepository.findAll();
    }

    public Group update(Group group){
        return groupRepository.save(group);
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
