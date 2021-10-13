package my.project.calendarsystem.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.calendarsystem.daos.interfaces.UserDAO;
import my.project.calendarsystem.dtos.UserDTO;
import my.project.calendarsystem.exceptions.UserExistsException;
import my.project.calendarsystem.exceptions.UserNotFoundException;
import my.project.calendarsystem.models.User;
import my.project.calendarsystem.services.interfaces.UserService;
import my.project.calendarsystem.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO register(UserDTO userDTO) {
        if (userDTO==null) throw new UserNotFoundException("User not found");
        if (userDTO.getEmail()==null||userDTO.getEmail().equals("")) throw new NullPointerException();
        User user = modelMapper.map(userDTO,User.class);
        User checkUser = userDAO.findByEmail(user);
        if (checkUser!=null) throw new UserExistsException("User already exists!!");
        user.setPassword(Helper.passEncode("12345"));
        return modelMapper.map(userDAO.save(user),UserDTO.class);
    }
}
