package my.project.calendarsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
