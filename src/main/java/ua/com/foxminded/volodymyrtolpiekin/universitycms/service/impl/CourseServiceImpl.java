package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.CourseDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Course;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.CourseRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.CourseService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper mapper;

    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    @Override
    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public Course findById(Long id){
        return courseRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not found"));
    }

    @Override
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    @Override
    public Course update(Course course){
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id){
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }
    }

    @Override
    public List<CourseDTO> getAll() {
        return findAll()
                .stream()
                .map(course -> mapper.map(course, CourseDTO.class))
                .collect(toList());
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = mapper.map(courseDTO, Course.class);
        return mapper.map(addCourse(course), CourseDTO.class);
    }

    @Override
    public CourseDTO readById(Long courseId) {
        return mapper.map(findById(courseId), CourseDTO.class);
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        Course course = mapper.map(courseDTO, Course.class);
        Course returnedCourse = update(course);
        return mapper.map(returnedCourse, CourseDTO.class);
    }
}
