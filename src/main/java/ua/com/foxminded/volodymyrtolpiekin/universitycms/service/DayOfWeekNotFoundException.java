package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="DayOfWeek Not Found")
public class DayOfWeekNotFoundException extends RuntimeException {

    public DayOfWeekNotFoundException(Long id) {
        super(String.format("DayOfWeekNotFoundException with id=%d", id));
    }
}