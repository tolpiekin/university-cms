package ua.com.foxminded.volodymyrtolpiekin.universitycms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Group Not Found")
public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(Long id) {
        super(String.format("GroupNotFoundException with id=%d", id));
    }
}