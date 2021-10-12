package my.project.calendarsystem.services.interfaces;

import my.project.calendarsystem.dtos.CalendarDTO;
import my.project.calendarsystem.models.Calendar;

import java.util.List;

public interface CalendarService {
    CalendarDTO create(CalendarDTO newCalendar);
    CalendarDTO read(long id);
    List<CalendarDTO> readAll();
    void delete(long id);
}
