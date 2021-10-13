package my.project.calendarsystem.repos;

import my.project.calendarsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
}
