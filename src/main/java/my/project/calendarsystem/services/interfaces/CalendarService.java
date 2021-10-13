package my.project.calendarsystem.services.interfaces;

import my.project.calendarsystem.dtos.CalendarDTO;
import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.models.User;

import java.util.List;

public interface CalendarService {
    CalendarDTO create(CalendarDTO newCalendar, User user);
    CalendarDTO read(long id, User user);
    List<CalendarDTO> readAll();
    CalendarDTO update(long calendarId, CalendarDTO updatedCalendar,User user);
    void delete(long id,User user);
}
