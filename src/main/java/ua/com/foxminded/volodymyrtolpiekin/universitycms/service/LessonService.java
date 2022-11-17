package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Lesson;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.LessonRepository;

import java.util.List;
import java.util.Optional;

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
        return Optional.of(lessonRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Lesson Not Found")).get();
    }

    public List<Lesson> findAll(){
        return lessonRepository.findAll();
    }

    public Lesson update(Long id, Lesson lesson){
        return lessonRepository.save(lesson);
    }

    public void deleteById(Long id){
        Optional.of(lessonRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Lesson Not Found"));
        lessonRepository.deleteById(id);
    }
}
