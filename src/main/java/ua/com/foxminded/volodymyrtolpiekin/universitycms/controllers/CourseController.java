package ua.com.foxminded.volodymyrtolpiekin.universitycms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.CourseDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.mapper.CourseMapper;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.CourseService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper mapper;

    public CourseController(CourseService courseService, CourseMapper mapper) {
        this.courseService = courseService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CourseDTO> showCoursesList() {
        return courseService.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody CourseDTO courseDTO) {
        Course course = mapper.toCourse(courseDTO);
        courseService.addCourse(course);
        return course;
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteStudent(@PathVariable("courseId") Long courseId) {
        courseService.deleteById(courseId);
    }

    @GetMapping(path = "{courseId}")
    public CourseDTO getOneCourse(@PathVariable("courseId") Long courseId) {
        Course course = courseService.findById(courseId);
        return mapper.toDto(course);
    }

    @PutMapping(path = "{courseId}")
    public void updateCourse(
            @PathVariable("courseId") Long courseId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long groupId,
            @RequestParam(required = false) Long tutorId
    ) {
        CourseDTO courseDTO = new CourseDTO(courseId, name, groupId, tutorId);
        courseService.update(mapper.toCourse(courseDTO));
    }

    @PutMapping(path = "assign-teacher/{courseId}")
    public void assignTeacher(
            @PathVariable("courseId") Long courseId,
            @RequestParam Long tutorId
    ) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(courseId);
        courseDTO.setTutorId(tutorId);
        courseService.update(mapper.toCourse(courseDTO));
    }

    @PutMapping(path = "assign-group/{courseId}")
    public void assignGroup(
            @PathVariable("courseId") Long courseId,
            @RequestParam Long groupId
    ) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(courseId);
        courseDTO.setGroupId(groupId);
        courseService.update(mapper.toCourse(courseDTO));
    }
}
