package ua.com.foxminded.volodymyrtolpiekin.universitycms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Tutor Not Found")
public class TutorNotFoundException extends RuntimeException {

    public TutorNotFoundException(Long id) {
        super(String.format("TutorNotFoundException with id=%d", id));
    }
}