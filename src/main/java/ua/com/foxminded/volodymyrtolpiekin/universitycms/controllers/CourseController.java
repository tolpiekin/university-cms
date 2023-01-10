package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.CourseDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.CourseService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseController {
    private final CourseService courseService;
    private final ModelMapper mapper;

    public CourseController(CourseService courseService, ModelMapper mapper) {
        this.courseService = courseService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CourseDTO> showCoursesList() {
        return courseService.readAllDTOs();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.addCourseDTO(courseDTO);
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteStudent(@PathVariable("courseId") Long courseId) {
        courseService.deleteById(courseId);
    }

    @GetMapping(path = "{courseId}")
    public CourseDTO getOneCourse(@PathVariable("courseId") Long courseId) {
        Course course = courseService.findById(courseId);
        return mapper.map(course, CourseDTO.class);
    }

    @PutMapping
    public void updateCourse(@RequestBody CourseDTO courseDTO) {
        courseService.update(mapper.map(courseDTO, Course.class));
    }

    @PutMapping(path = "assign-teacher/{courseId}")
    public Course assignTeacher(@RequestBody CourseDTO courseDTO) {
        return courseService.update(mapper.map(courseDTO, Course.class));
    }

    @PutMapping(path = "assign-group/{courseId}")
    public void assignGroup(@RequestBody CourseDTO courseDTO) {
        courseService.update(mapper.map(courseDTO, Course.class));
    }
}
