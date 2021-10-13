package my.project.calendarsystem.services;

import lombok.RequiredArgsConstructor;
import my.project.calendarsystem.daos.interfaces.CalendarForUsersDao;
import my.project.calendarsystem.exceptions.CalendarNotFoundException;
import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.models.CalendarForUser;
import my.project.calendarsystem.models.User;
import my.project.calendarsystem.services.interfaces.CalendarForUsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarForUsersServiceImp implements CalendarForUsersService {

    private final CalendarForUsersDao calendarForUsersDao;

    @Override
    public CalendarForUser create(Calendar calendar, User user) {
        return calendarForUsersDao.create(calendar,user);
    }

    @Override
    public CalendarForUser getCalForUser(Calendar calendar, User user) {
        CalendarForUser calendarForUser = calendarForUsersDao.read(calendar.getID(), user.getId());
        if (calendarForUser==null) throw new CalendarNotFoundException("Calendar Not Found");
        if (calendarForUser.getCalendar().getDeletedDate()!=null) throw new CalendarNotFoundException("Calendar Not Found");
        calendarForUser.setRead(true);
        calendarForUsersDao.save(calendarForUser);
        return calendarForUser;
    }
}
