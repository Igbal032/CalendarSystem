package my.project.calendarsystem.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "calendars")
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
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
    @CreationTimestamp
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
}
