package ua.com.foxminded.volodymyrtolpiekin.universitycms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
