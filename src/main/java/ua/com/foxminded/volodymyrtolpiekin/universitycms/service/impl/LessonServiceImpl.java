package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.LessonDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Lesson;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Student;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.LessonRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.GroupService;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.LessonService;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.StudentService;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.TutorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final StudentService studentService;
    private final GroupService groupService;
    private final TutorService tutorService;
    private final ModelMapper mapper;

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

    @Override
    public List<LessonDTO> getAll() {
        return findAll()
                .stream()
                .map(lesson -> mapper.map(lesson, LessonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Lesson lesson = mapper.map(lessonDTO, Lesson.class);
        return mapper.map(addLesson(lesson), LessonDTO.class);
    }

    @Override
    public LessonDTO getById(Long lessonId) {
        return mapper.map(findById(lessonId), LessonDTO.class);
    }

    @Override
    public LessonDTO update(LessonDTO lessonDTO) {
        Lesson lesson = mapper.map(lessonDTO, Lesson.class);
        Lesson returnedLesson = update(lesson);
        return mapper.map(returnedLesson, LessonDTO.class);
    }

    @Override
    public List<LessonDTO> getByStudentId(Long studentId) {
        Student student = studentService.findById(studentId);
        return lessonRepository.findByGroupId(student.getId())
                .stream()
                .map(lesson -> mapper.map(lesson, LessonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LessonDTO> getByTutorId(Long tutorId) {
        return lessonRepository.findByTutorId(tutorId)
                .stream()
                .map(lesson -> mapper.map(lesson, LessonDTO.class))
                .collect(Collectors.toList());
    }
}
