package ua.com.foxminded.volodymyrtolpiekin.universitycms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
