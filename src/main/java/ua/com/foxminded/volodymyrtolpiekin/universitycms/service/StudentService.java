package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Student;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> addStudent(Student student){
        studentRepository.save(student);
        return findById(student.getId());
    }

    public Optional<Student> findById(Long id){
        try {
            return Optional.of(studentRepository.findById(id)).orElseThrow(()->new StudentNotFoundException(id));
        }
        catch (StudentNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found", exc);
        }
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> update(Long id, Student student){
        student.setId(id);
        studentRepository.save(student);
        return studentRepository.findById(id);
    }

    public void deleteById(Long id){
        try {
            Optional.of(studentRepository.findById(id)).orElseThrow(()->new StudentNotFoundException(id));
        }
        catch (StudentNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found", exc);
        }
        studentRepository.deleteById(id);
    }
}
