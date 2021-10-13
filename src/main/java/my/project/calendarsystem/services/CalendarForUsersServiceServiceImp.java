package my.project.calendarsystem.services;

import lombok.RequiredArgsConstructor;
import my.project.calendarsystem.daos.interfaces.CalendarForUsersDao;
import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.models.CalendarForUser;
import my.project.calendarsystem.models.User;
import my.project.calendarsystem.services.interfaces.CalendarForUsersService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalendarForUsersServiceServiceImp implements CalendarForUsersService {

    private final CalendarForUsersDao calendarForUsersDao;

    @Override
    public CalendarForUser create(Calendar calendar, User user) {
        return calendarForUsersDao.create(calendar,user);
    }

    @Override
    public CalendarForUser read(Calendar calendar, User user) {
        CalendarForUser calendarForUser = calendarForUsersDao.read(calendar.getID(), user.getId());
        calendarForUser.setRead(true);
        calendarForUsersDao.save(calendarForUser);
        return calendarForUser;
    }
}
