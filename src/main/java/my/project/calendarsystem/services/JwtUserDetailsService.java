package my.project.calendarsystem.services;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import my.project.calendarsystem.repos.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        my.project.calendarsystem.models.User user =  userRepo.findUserByEmail(email);
        if (user!=null){
            return new User(email, user.getPassword(),
                    new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}