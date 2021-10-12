package my.project.calendarsystem.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "calendar_for_users")
public class CalendarForUser {

    @Id
    private long id;
    @OneToOne
    private Calendar calendar;
    @OneToOne
    private User user;
}
