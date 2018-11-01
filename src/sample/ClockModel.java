package sample;

import java.time.LocalDateTime;
import java.util.Date;

public class ClockModel {
    Date date = new Date();
    private LocalDateTime localDateTime = LocalDateTime.now();
    private int hour = date.getHours();
    private int minute = date.getMinutes();
    private int sec = date.getSeconds();


//    private int hour = localDateTime.getHour();
//    private int minute = localDateTime.getMinute();


    public ClockModel() {
        this.date = date;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Date setTime() {
        return date;
    }

    public int getSec() {
        return sec;
    }
}
