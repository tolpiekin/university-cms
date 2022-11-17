package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Lesson;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.LessonRepository;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson addLesson(Lesson lesson){
        return lessonRepository.save(lesson);
    }

    public Lesson findById(Long id){
        return lessonRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Lesson Not Found"));
    }

    public List<Lesson> findAll(){
        return lessonRepository.findAll();
    }

    public Lesson update(Lesson lesson){
        return lessonRepository.save(lesson);
    }

    public void deleteById(Long id){
        findById(id);
        lessonRepository.deleteById(id);
    }
}
