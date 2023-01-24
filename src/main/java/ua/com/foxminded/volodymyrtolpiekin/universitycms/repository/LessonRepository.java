package ua.com.foxminded.volodymyrtolpiekin.universitycms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Lesson;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByGroupId(Long groupId);
    List<Lesson> findByTutorId(Long tutorId);
}
