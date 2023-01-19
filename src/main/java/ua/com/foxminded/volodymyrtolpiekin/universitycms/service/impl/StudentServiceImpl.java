package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.dto.StudentDTO;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Student;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.StudentRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper mapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found"));
    }

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Override
    public Student update(Student student){
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id){
        findById(id);
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> getAll() {
        return findAll()
                .stream()
                .map(student -> mapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = mapper.map(studentDTO, Student.class);
        return mapper.map(addStudent(student), StudentDTO.class);
    }

    @Override
    public StudentDTO readById(Long studentId) {
        Student student = findById(studentId);
        return mapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        Student student = mapper.map(studentDTO, Student.class);
        Student returnedStudent= update(student);
        return mapper.map(returnedStudent, StudentDTO.class);
    }
}
