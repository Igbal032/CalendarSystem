package my.project.calendarsystem.daos.interfaces;

import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.models.CalendarForUser;
import my.project.calendarsystem.models.User;

public interface CalendarForUsersDao {
    CalendarForUser create(Calendar cal, User user);
    CalendarForUser read(long calId, long userId);
    CalendarForUser save(CalendarForUser calendarForUser);
}
