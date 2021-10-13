package my.project.calendarsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "calendar_for_users")
public class CalendarForUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Calendar calendar;
    @OneToOne
    private User user;
    private boolean isRead;
}
