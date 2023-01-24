package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.GroupDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Group;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.GroupRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.GroupService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final ModelMapper mapper;

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

    @Override
    public List<GroupDTO> getAll() {
        return findAll()
                .stream()
                .map(course -> mapper.map(course, GroupDTO.class))
                .collect(toList());
    }

    @Override
    public GroupDTO createGroup(GroupDTO groupDTO) {
        Group group = mapper.map(groupDTO, Group.class);
        return mapper.map(addGroup(group), GroupDTO.class);
    }

    @Override
    public GroupDTO getById(Long groupId) {
        return mapper.map(findById(groupId), GroupDTO.class);
    }

    @Override
    public GroupDTO update(GroupDTO groupDTO) {
        Group group = mapper.map(groupDTO, Group.class);
        Group returnedGroup = update(group);
        return mapper.map(returnedGroup, GroupDTO.class);
    }
}
