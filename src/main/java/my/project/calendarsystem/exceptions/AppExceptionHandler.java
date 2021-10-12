package my.project.calendarsystem.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "Error happened.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "Please fill out all of the fields.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }

    @ExceptionHandler(value = {DateFormatException.class})
    public ResponseEntity<Object> handleDateFormatException(DateFormatException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,
                ex.getLocalizedMessage(), "Not correct date format.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
    @ExceptionHandler(value = {NotCorrectDateException.class})
    public ResponseEntity<Object> handleLoginException(NotCorrectDateException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,
                ex.getLocalizedMessage(), "Not correct date format.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
    @ExceptionHandler(value = {NotZeroException.class})
    public ResponseEntity<Object> handleLoginException(NotZeroException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,
                ex.getLocalizedMessage(), "id could not be zero.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
    @ExceptionHandler(value = {CalendarNotFoundException.class})
    public ResponseEntity<Object> handleLoginException(CalendarNotFoundException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,
                ex.getLocalizedMessage(), "Calendar Not Found Exception.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
}
