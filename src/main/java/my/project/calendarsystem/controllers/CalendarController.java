package my.project.calendarsystem.controllers;

import lombok.RequiredArgsConstructor;
import my.project.calendarsystem.dtos.CalendarDTO;
import my.project.calendarsystem.services.interfaces.CalendarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    /**
     * Method is used for creating new calendar
     * @return
     */
    @PostMapping
    public ResponseEntity create(@RequestBody CalendarDTO calendarDTO){
        return new ResponseEntity(calendarService.create(calendarDTO),HttpStatus.OK);
    }

    /**
     * This method is used for getting one calendar by id
     * @PathVariable  calendar-id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity readOne(@PathVariable long id){
        return new ResponseEntity(calendarService.read(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity readAll(){
        return new ResponseEntity(calendarService.readAll(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CalendarDTO calendarDTO){

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){

        return new ResponseEntity(HttpStatus.OK);
    }
}
