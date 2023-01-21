package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.CourseDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.CourseService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDTO> showCoursesList() {
        return courseService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.deleteById(courseId);
    }

    @GetMapping(path = "{courseId}")
    public CourseDTO getCourse(@PathVariable("courseId") Long courseId) {
        return courseService.getById(courseId);
    }

    @PutMapping
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.update(courseDTO);
    }

    @PutMapping(path = "assign-teacher/{courseId}")
    public CourseDTO assignTeacher(@RequestBody CourseDTO courseDTO) {
        return courseService.update(courseDTO);
    }

    @PutMapping(path = "assign-group/{courseId}")
    public CourseDTO assignGroup(@RequestBody CourseDTO courseDTO) {
        return courseService.update(courseDTO);
    }
}
