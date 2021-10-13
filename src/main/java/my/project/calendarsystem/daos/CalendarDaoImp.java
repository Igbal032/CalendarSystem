package my.project.calendarsystem.daos;

import lombok.RequiredArgsConstructor;
import my.project.calendarsystem.daos.interfaces.CalendarDAO;
import my.project.calendarsystem.exceptions.CalendarNotFoundException;
import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.repos.CalendarRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CalendarDaoImp implements CalendarDAO {

    private final CalendarRepo calendarRepo;

    @Override
    public Calendar save(Calendar newCalendar) {
        return calendarRepo.save(newCalendar);
    }

    @Override
    public Calendar read(long id) {
        return calendarRepo.getById(id);
    }

    @Override
    public List<Calendar> readAll() {
        return calendarRepo.findAll().stream().filter(w->w.getDeletedDate()==null).collect(Collectors.toList());
    }

    @Override
    public void delete(long id) {
        Calendar calendar = read(id);
        if (calendar==null) throw new CalendarNotFoundException("Calendar not found");
        calendar.setDeletedDate(LocalDateTime.now());
        calendarRepo.save(calendar);
    }
}
