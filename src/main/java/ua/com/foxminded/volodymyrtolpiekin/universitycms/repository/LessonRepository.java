package ua.com.foxminded.volodymyrtolpiekin.universitycms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
