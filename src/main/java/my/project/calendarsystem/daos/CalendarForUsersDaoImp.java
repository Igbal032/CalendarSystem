package my.project.calendarsystem.daos;

import lombok.RequiredArgsConstructor;
import my.project.calendarsystem.daos.interfaces.CalendarForUsersDao;
import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.models.CalendarForUser;
import my.project.calendarsystem.models.User;
import my.project.calendarsystem.repos.CalendarForUserRepo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalendarForUsersDaoImp implements CalendarForUsersDao {

    private final CalendarForUserRepo calendarForUserRepo;

    @Override
    public CalendarForUser create(Calendar cal, User user) {
        CalendarForUser calForUser = new CalendarForUser();
        calForUser.setCalendar(cal);
        calForUser.setUser(user);
        calForUser.setRead(false);
        calendarForUserRepo.save(calForUser);
        return calForUser;
    }

    @Override
    public CalendarForUser read(long calId, long userId) {
        return calendarForUserRepo.findCalendarForUserByCalendarIDAndUserId(calId,userId);
    }

    @Override
    public CalendarForUser save(CalendarForUser calendarForUser) {
        return calendarForUserRepo.save(calendarForUser);
    }
}
