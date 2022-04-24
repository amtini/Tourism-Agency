package backend.Functions;

import java.time.LocalDateTime;

public class DateFunctions {
    static public Integer getMinutesOfDay(LocalDateTime time){
        return (time.getHour() * 60) + time.getMinute();
    }
}