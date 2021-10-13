package my.project.calendarsystem.daos.interfaces;

import my.project.calendarsystem.models.User;

public interface UserDAO {
    User save(User user);
    User findByEmail(User user);
}
