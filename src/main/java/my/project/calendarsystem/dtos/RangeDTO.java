package my.project.calendarsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RangeDTO {
    LocalDateTime fromT;
    LocalDateTime toT;

}
