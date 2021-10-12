package my.project.calendarsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "calendars")
@Setter
@Getter
public class Calendar {
    @Id
    private long id;
    private String title;
    private String detail;
    private String type;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private int beNotified;
    private String timeColor;
    @ManyToOne
    private User user;
    private LocalDateTime notifiedDate;
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
}
