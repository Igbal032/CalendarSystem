package my.project.calendarsystem.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.calendarsystem.config.WebSecurityConfig;
import my.project.calendarsystem.enums.Color;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.temporal.ChronoUnit;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
public class Helper {


    public static long calRangeBetweenTwoLocalDateTime(LocalDateTime fromT, LocalDateTime toT){
        long days = ChronoUnit.DAYS.between(fromT,toT);
        return days;
    }
    public static Color getColorBasedOnDay(long day){
        if (day<=Color.RED.getDay()&&day>=0)
            return Color.RED;
        else if (day>Color.RED.getDay()&&day<=Color.ORANGE.getDay())
            return Color.ORANGE;
        else if (day>Color.ORANGE.getDay()&&day<=Color.YELLOW.getDay())
            return Color.YELLOW;
        else return Color.BLUE;
    }
    public static boolean checkDate(LocalDateTime fromT, LocalDateTime toT){
        if (fromT.isAfter(LocalDateTime.now())&&toT.isAfter(LocalDateTime.now())){
            if (fromT.isBefore(toT)){
                return true;
            }
            log.error("FROM_DATE MUST BE BEFORE TO_DATE");
            return false;
        }
        log.error("FROM_DATE and TO_DATE must be after CURRENT_DATE");
        return false;
    }
    public static String passEncode(String password){
        String encodePass = new BCryptPasswordEncoder().encode(password);
        log.info(encodePass);
        return encodePass;
    }

}
