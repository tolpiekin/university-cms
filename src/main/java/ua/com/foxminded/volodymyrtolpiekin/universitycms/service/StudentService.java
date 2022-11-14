package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Student;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> addStudent(Student student){
        return Optional.of(studentRepository.save(student));
    }

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
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

    }
}
