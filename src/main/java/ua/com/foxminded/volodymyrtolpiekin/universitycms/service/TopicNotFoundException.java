package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Topic Not Found")
public class TopicNotFoundException extends RuntimeException {

    public TopicNotFoundException(Long id) {
        super(String.format("TopicNotFoundException with id=%d", id));
    }
}