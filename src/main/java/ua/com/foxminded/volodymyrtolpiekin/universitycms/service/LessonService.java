package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Lesson;

import java.util.List;

public interface LessonService {
    Lesson addLesson(Lesson lesson);

    Lesson findById(Long id);

    List<Lesson> findAll();

    Lesson update(Lesson lesson);

    void deleteById(Long id);
}
