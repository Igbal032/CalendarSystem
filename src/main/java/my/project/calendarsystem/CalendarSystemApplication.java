package my.project.calendarsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class CalendarSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarSystemApplication.class, args);
    }

}
