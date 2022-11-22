package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.DayOfWeek;

import java.util.List;

public interface DayOfWeekService {
    DayOfWeek addDayOfWeek(DayOfWeek dayOfWeek);

    DayOfWeek findById(Long id);

    List<DayOfWeek> findAll();

    DayOfWeek update(DayOfWeek dayOfWeek);

    void deleteById(Long id);
}
