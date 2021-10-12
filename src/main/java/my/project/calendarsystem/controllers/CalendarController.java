package my.project.calendarsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendars")
public class CalendarController {

    @RequestMapping
    public ResponseEntity getCalendars(){

        return new ResponseEntity(HttpStatus.OK);
    }
}
