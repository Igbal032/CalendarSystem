package my.project.calendarsystem.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.calendarsystem.daos.interfaces.CalendarDAO;
import my.project.calendarsystem.dtos.CalendarDTO;
import my.project.calendarsystem.enums.Color;
import my.project.calendarsystem.exceptions.CalendarNotFoundException;
import my.project.calendarsystem.exceptions.NotAccessException;
import my.project.calendarsystem.exceptions.NotCorrectDateException;
import my.project.calendarsystem.exceptions.NotZeroException;
import my.project.calendarsystem.models.Calendar;
import my.project.calendarsystem.models.User;
import my.project.calendarsystem.services.interfaces.CalendarService;
import my.project.calendarsystem.utils.Helper;
import net.bytebuddy.description.method.MethodDescription;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CalendarServiceImp implements CalendarService {

    private final ModelMapper modelMapper;
    private final CalendarDAO calendarDAO;

    @Value("${app.admin.role}")
    private String adminRole;
    @Value("${app.user.role}")
    private String userRole;

    @Override
    public CalendarDTO create(CalendarDTO newCalendar,User user) {
        if (Helper.checkDate(newCalendar.getFromDate(),newCalendar.getToDate())){
            Calendar calendar = modelMapper.map(newCalendar, Calendar.class);
            long range = Helper.calRangeBetweenTwoLocalDateTime(calendar.getFromDate(),LocalDateTime.now());
            Color timeColor = Helper.getColorBasedOnDay(range);
            LocalDateTime notifiedDate = calendar.getFromDate().minusDays(calendar.getBeNotified());
            calendar = calendar.toBuilder()
                    .timeColor(timeColor.toString())
                    .user(user)
                    .notifiedDate(notifiedDate)
                    .build();
            Calendar saved = calendarDAO.save(calendar);
            CalendarDTO convertToDto = modelMapper.map(saved, CalendarDTO.class);
            return convertToDto;
        }
        throw new NotCorrectDateException("Wrong DateTime");
    }

    @Override
    public CalendarDTO read(long id) {
        if (id!=0){
            Calendar calendar =  calendarDAO.read(id);
            if (calendar==null) throw new CalendarNotFoundException("Calendar not found with this id.");
            return modelMapper.map(calendar,CalendarDTO.class);
        }
        log.error("id must not be 0");
        throw new NotZeroException("id must not be 0");
    }

    @Override
    public List<CalendarDTO> readAll() {
        List<Calendar> calendarList = calendarDAO.readAll();
        if (calendarList.size()==0) throw new CalendarNotFoundException("There are no any calendars!");
        log.info("All Calendars..");
        return Arrays.asList(modelMapper.map(calendarList,CalendarDTO[].class));
    }

    @Override
    public CalendarDTO update(long Id, CalendarDTO updatedCalendar, User user) {
        if (Id==0) throw new NotZeroException("Id must not be 0");
        Calendar findCalendar = calendarDAO.read(Id);
        log.error((user.getEmail()!=findCalendar.getUser().getEmail()) + " gorek");
        if ((user.getRole().equals(adminRole)&&findCalendar.getUser().getRole().equals(adminRole))
                ||user.getEmail()==findCalendar.getUser().getEmail()){
            if (Helper.checkDate(updatedCalendar.getFromDate(), updatedCalendar.getToDate())) {
                Calendar calendar = modelMapper.map(updatedCalendar, Calendar.class);
                long range = Helper.calRangeBetweenTwoLocalDateTime(calendar.getFromDate(), LocalDateTime.now());
                Color timeColor = Helper.getColorBasedOnDay(range);
                LocalDateTime notifiedDate = calendar.getFromDate().minusDays(calendar.getBeNotified());
                calendar = calendar.toBuilder()
                        .ID(findCalendar.getID())
                        .createdDate(findCalendar.getCreatedDate())
                        .timeColor(timeColor.toString())
                        .notifiedDate(notifiedDate)
                        .user(user)
                        .build();
                Calendar saved = calendarDAO.save(calendar);
                CalendarDTO convertToDto = modelMapper.map(saved, CalendarDTO.class);
                return convertToDto;
            }
            throw new NotCorrectDateException("Wrong DateTime");
        }
        else throw new NotAccessException("Only creator update this event");
    }

    @Override
    public void delete(long id,User user) {
    if (id==0) throw new NotZeroException("Id must not be 0");
    Calendar findCalendar = calendarDAO.read(id);
    if (!(user.getRole().equals(adminRole)&&user.getRole().equals(adminRole))
            ||(user.getId()!=findCalendar.getUser().getId())) throw new NotAccessException("Only creator update this event");
    calendarDAO.delete(id);
    }
}
