package my.project.calendarsystem.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super("User not found with this email");
    }
}
