package my.project.calendarsystem.utils;

import my.project.calendarsystem.enums.Color;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    void testGetColorBasedOnDay() {
        //given
        int day = 4;
        int day4 = 9;
        int day2 = 15;
        int day3 = 25;
        //when
        Color timeColor = Helper.getColorBasedOnDay(day);
        Color timeColor2 = Helper.getColorBasedOnDay(day2);
        Color timeColor3 = Helper.getColorBasedOnDay(day3);
        Color timeColor4 = Helper.getColorBasedOnDay(day4);
        //then
        assertEquals(timeColor.toString(),"RED");
        assertEquals(timeColor2.toString(),"YELLOW");
        assertEquals(timeColor4.toString(),"ORANGE");
        assertEquals(timeColor3.toString(),"BLUE");
    }

    @Test
    void checkDate() {
        //given
        LocalDateTime fromT = LocalDateTime.of(2021,12,13,05,06,10);
        LocalDateTime toT = LocalDateTime.of(2021,12,16,05,06,10);
        //when
        boolean result =  Helper.checkDate(fromT,toT);
        //Then
        assertEquals(result, true);
    }
}