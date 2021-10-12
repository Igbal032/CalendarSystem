package my.project.calendarsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CalendarDTO {
    private String title;
    private String detail;
    private String type;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private int beNotified;
}
