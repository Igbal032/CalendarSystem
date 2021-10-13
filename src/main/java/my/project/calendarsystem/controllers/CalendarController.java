package my.project.calendarsystem.controllers;

import lombok.RequiredArgsConstructor;
import my.project.calendarsystem.config.JwtTokenUtil;
import my.project.calendarsystem.dtos.CalendarDTO;
import my.project.calendarsystem.dtos.RangeDTO;
import my.project.calendarsystem.models.User;
import my.project.calendarsystem.services.interfaces.CalendarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendars")
public class CalendarController {

    private final CalendarService calendarService;
    private final JwtTokenUtil jwtTokenUtil;

    /**
     * Method is used for creating new calendar
     * @return
     */
    @PostMapping
    public ResponseEntity create(@RequestBody CalendarDTO calendarDTO, HttpServletRequest request){
        User user = jwtTokenUtil.getUserId(request.getHeader("Authorization"));
        return new ResponseEntity(calendarService.create(calendarDTO,user),HttpStatus.OK);
    }

    /**
     * This method is used for getting calendar by id
     * @PathVariable  calendar-id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity readOne(@PathVariable long id,HttpServletRequest request){
        User user = jwtTokenUtil.getUserId(request.getHeader("Authorization"));
        return new ResponseEntity(calendarService.read(id,user),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity readAll(){
        return new ResponseEntity(calendarService.readAll(),HttpStatus.OK);
    }

    /**
     * This method is used for updating calendar
     * @PathVariable  calendar-id
     * @RequestBody calendarDTO
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id,@RequestBody CalendarDTO calendarDTO,HttpServletRequest request){
        User user = jwtTokenUtil.getUserId(request.getHeader("Authorization"));
        return new ResponseEntity(calendarService.update(id,calendarDTO,user),HttpStatus.OK);
    }
    /**
     * This method is used for deleting calendar
     * @PathVariable  calendar-id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id,HttpServletRequest request){
        User user = jwtTokenUtil.getUserId(request.getHeader("Authorization"));
        calendarService.delete(id,user);
        return new ResponseEntity(HttpStatus.OK);
    }
    /**
     * This method is used for getting calendar between two DATE
     * @RequestParam fromT
     * @RequestParam toT
     * @return
     */
    @GetMapping("/range")
    public ResponseEntity calendarsBasedOnDate(@RequestBody RangeDTO rangeDTO){
        return new ResponseEntity(calendarService.getCalendarsBetweenTwoDay(rangeDTO),HttpStatus.OK);
    }
}
