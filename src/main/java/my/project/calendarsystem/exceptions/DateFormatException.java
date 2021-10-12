package my.project.calendarsystem.exceptions;


public class DateFormatException extends RuntimeException{
    public DateFormatException(String message) {
        super("Please, write date correct variant");
    }
}
