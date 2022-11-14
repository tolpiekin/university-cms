package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Course Not Found")
public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {
        super(String.format("CourseNotFoundException with id=%d", id));
    }
}