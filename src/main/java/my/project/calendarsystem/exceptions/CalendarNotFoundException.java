package my.project.calendarsystem.exceptions;

public class CalendarNotFoundException extends RuntimeException{
    public CalendarNotFoundException(String message) {
        super(message);
    }
}
