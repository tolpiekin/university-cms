package ua.com.foxminded.volodymyrtolpiekin.universitycms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Timetable Not Found")
public class TimetableNotFoundException extends RuntimeException {

    public TimetableNotFoundException(Long id) {
        super(String.format("TimetableNotFoundException with id=%d", id));
    }
}