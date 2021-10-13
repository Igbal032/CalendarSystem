package my.project.calendarsystem.repos;

import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.models.CalendarForUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarForUserRepo extends JpaRepository<CalendarForUser,Long> {
    CalendarForUser findCalendarForUserByCalendarIDAndUserId (long calId, long userId);
}
