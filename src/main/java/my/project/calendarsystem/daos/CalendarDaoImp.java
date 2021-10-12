package my.project.calendarsystem.daos;

import lombok.RequiredArgsConstructor;
import my.project.calendarsystem.daos.interfaces.CalendarDAO;
import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.repos.CalendarRepo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CalendarDaoImp implements CalendarDAO {

    private final CalendarRepo calendarRepo;

    @Override
    public Calendar create(Calendar newCalendar) {
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
}
