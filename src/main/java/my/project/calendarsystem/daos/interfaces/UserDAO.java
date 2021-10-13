package my.project.calendarsystem.daos.interfaces;

import my.project.calendarsystem.models.User;

import java.util.List;

public interface UserDAO {
    User save(User user);
    User findByEmail(User user);
    List<User> allUsers();

}
