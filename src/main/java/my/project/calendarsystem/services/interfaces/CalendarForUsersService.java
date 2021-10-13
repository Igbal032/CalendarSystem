package my.project.calendarsystem.services.interfaces;

import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.models.CalendarForUser;
import my.project.calendarsystem.models.User;

public interface CalendarForUsersService {
    CalendarForUser create(Calendar calendar, User user);
    CalendarForUser read(Calendar calendar, User user);
}
