package my.project.calendarsystem.daos.interfaces;

import my.project.calendarsystem.dtos.CalendarDTO;
import my.project.calendarsystem.models.Calendar;

import java.util.List;

public interface CalendarDAO {
    Calendar save(Calendar newCalendar);
    Calendar read(long id);
    List<Calendar> readAll();
}
