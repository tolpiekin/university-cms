package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.GroupDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.GroupService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupDTO> showGroupsList() {
        return groupService.readAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDTO createGroup(@RequestBody GroupDTO groupDTO) {
        return groupService.createGroup(groupDTO);
    }

    @DeleteMapping(path = "{groupId}")
    public void deleteGroup(@PathVariable("groupId") Long groupId) {
        groupService.deleteById(groupId);
    }

    @GetMapping(path = "{groupId}")
    public GroupDTO getGroup(@PathVariable("groupId") Long groupId) {
        return groupService.readById(groupId);
    }

    @PutMapping
    public GroupDTO updateGroup(@RequestBody GroupDTO groupDTO) {
        return groupService.update(groupDTO);
    }
}
