package my.project.calendarsystem.exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String message) {
        super("User has already exists");
    }
}
