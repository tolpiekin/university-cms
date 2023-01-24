package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.LessonDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.LessonService;

import java.util.List;


@RestController
@RequestMapping(path = "/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final LessonService lessonService;

    @GetMapping
    public List<LessonDTO> showLessonsList() {
        return lessonService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LessonDTO createLesson(@RequestBody LessonDTO lessonDTO) {
        return lessonService.createLesson(lessonDTO);
    }

    @DeleteMapping(path = "{lessonId}")
    public void deleteLesson(@PathVariable("lessonId") Long lessonId) {
        lessonService.deleteById(lessonId);
    }

    @GetMapping(path = "{lessonId}")
    public LessonDTO getSchedule(@PathVariable("lessonId") Long lessonId) {
        return lessonService.getById(lessonId);
    }

    @GetMapping(path = "student/{studentId}")
    public List<LessonDTO>  getScheduleForStudent(@PathVariable("studentId") Long studentId) {
        return lessonService.getByStudentId(studentId);
    }

    @GetMapping(path = "tutor/{tutorId}")
    public List<LessonDTO>  getScheduleForTutor(@PathVariable("tutorId") Long tutorId) {
        return lessonService.getByTutorId(tutorId);
    }

    @PutMapping
    public LessonDTO updateCourse(@RequestBody LessonDTO lessonDTO) {
        return lessonService.update(lessonDTO);
    }

}