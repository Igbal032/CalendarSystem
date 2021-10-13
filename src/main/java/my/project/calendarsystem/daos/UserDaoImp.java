package my.project.calendarsystem.daos;

import lombok.RequiredArgsConstructor;
import my.project.calendarsystem.daos.interfaces.UserDAO;
import my.project.calendarsystem.exceptions.UserNotFoundException;
import my.project.calendarsystem.models.User;
import my.project.calendarsystem.repos.UserRepo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDaoImp implements UserDAO {

    private final UserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findByEmail(User user)
    {
        return userRepo.findUserByEmail(user.getEmail());
    }
}
