package ua.com.foxminded.volodymyrtolpiekin.universitycms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.DayOfWeek;

@Repository
public interface DayOfWeekRepository extends JpaRepository<DayOfWeek, Long> {
}
