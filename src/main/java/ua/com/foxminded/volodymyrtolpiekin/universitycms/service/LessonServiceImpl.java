package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Lesson;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.LessonRepository;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Lesson addLesson(Lesson lesson){
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson findById(Long id){
        return lessonRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Lesson Not Found"));
    }

    @Override
    public List<Lesson> findAll(){
        return lessonRepository.findAll();
    }

    @Override
    public Lesson update(Lesson lesson){
        return lessonRepository.save(lesson);
    }

    @Override
    public void deleteById(Long id){
        findById(id);
        lessonRepository.deleteById(id);
    }
}
