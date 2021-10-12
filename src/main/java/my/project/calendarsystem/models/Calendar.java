package my.project.calendarsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
}
