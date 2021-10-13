package my.project.calendarsystem.services.interfaces;


import my.project.calendarsystem.dtos.UserDTO;
import my.project.calendarsystem.models.User;

import java.util.List;

public interface UserService {
    UserDTO register(UserDTO userDTO);
}
