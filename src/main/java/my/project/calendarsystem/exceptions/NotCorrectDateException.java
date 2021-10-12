package my.project.calendarsystem.exceptions;

public class NotCorrectDateException extends RuntimeException{
    public NotCorrectDateException(String message) {
        super("From_Date is before TO_Date, or DATAs is before current date");
    }
}
