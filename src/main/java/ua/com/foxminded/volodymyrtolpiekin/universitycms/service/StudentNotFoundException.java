package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Student Not Found")
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super(String.format("StudentNotFoundException with id=%d", id));
    }
}