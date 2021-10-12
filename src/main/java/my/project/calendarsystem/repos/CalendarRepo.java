package my.project.calendarsystem.repos;

import my.project.calendarsystem.models.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepo extends JpaRepository<Long, Calendar> {
}
