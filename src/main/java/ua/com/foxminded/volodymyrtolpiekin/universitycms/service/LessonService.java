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

    public Optional<Lesson> findById(Long id){
        return Optional.of(lessonRepository.findById(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Lesson Not Found"));
    }

    public List<Lesson> findAll(){
        return lessonRepository.findAll();
    }

    public Optional<Lesson> update(Long id, Lesson lesson){
        lesson.setId(id);
        lessonRepository.save(lesson);
        return lessonRepository.findById(id);
    }

    public void deleteById(Long id){
        try {
            Optional.of(lessonRepository.findById(id)).orElseThrow(()->new LessonNotFoundException(id));
        }
        catch (LessonNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lesson Not Found", exc);
        }
        lessonRepository.deleteById(id);
    }
}
