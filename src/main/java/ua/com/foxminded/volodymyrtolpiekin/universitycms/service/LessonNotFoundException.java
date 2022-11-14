package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Lesson Not Found")
public class LessonNotFoundException extends RuntimeException {

    public LessonNotFoundException(Long id) {
        super(String.format("LessonNotFoundException with id=%d", id));
    }
}