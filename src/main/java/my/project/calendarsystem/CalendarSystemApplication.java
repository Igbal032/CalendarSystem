package my.project.calendarsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CalendarSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarSystemApplication.class, args);
    }

}
