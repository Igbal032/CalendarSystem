package my.project.calendarsystem.dtos;

import lombok.Getter;
import lombok.Setter;
import my.project.calendarsystem.models.User;

import java.time.LocalDateTime;

@Getter
@Setter
public class CalendarDTO {
    private long ID;
    private String title;
    private String detail;
    private String type;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private int beNotified;
    private User user;
}
