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
    public ResponseEntity<Object> handleNotCorrectDateException(NotCorrectDateException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,
                ex.getLocalizedMessage(), "Not correct date format.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
    @ExceptionHandler(value = {NotZeroException.class})
    public ResponseEntity<Object> handleNotZeroException(NotZeroException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,
                ex.getLocalizedMessage(), "id could not be zero.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
    @ExceptionHandler(value = {CalendarNotFoundException.class})
    public ResponseEntity<Object> handleCalendarNotFoundException(CalendarNotFoundException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,
                ex.getLocalizedMessage(), "Calendar Not Found Exception.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,
                ex.getLocalizedMessage(), "User Not Found Exception.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
    @ExceptionHandler(value = {UserExistsException.class})
    public ResponseEntity<Object> handleUserExistsException(UserExistsException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,
                ex.getLocalizedMessage(), "User exists.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
    @ExceptionHandler(value = {NotAccessException.class})
    public ResponseEntity<Object> handleNotAccessException(NotAccessException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,
                ex.getLocalizedMessage(), "Only creator update.");
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), errorMessage.getStatus());
    }
}
