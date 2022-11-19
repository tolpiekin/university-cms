package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Timetable;

import java.util.List;

public interface TimetableService {
    Timetable addTimetable(Timetable timetable);

    Timetable findById(Long id);

    List<Timetable> findAll();

    Timetable update(Timetable timetable);

    void deleteById(Long id);
}
