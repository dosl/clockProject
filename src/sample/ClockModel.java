package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class ClockModel {
    Date date = new Date();
//    private LocalDateTime localDateTime = LocalDateTime.now();
    private int hour = date.getHours();
    private int minute = date.getMinutes();
    private int sec = date.getSeconds();
    private static ClockModel instance = null;
    private static ObservableList<ClockModel> timeList = FXCollections.observableArrayList();

    //    private int hour = localDateTime.getHour();
//    private int minute = localDateTime.getMinute();

    public void addTimeList(ClockProperty o){
        timeList.add(o);
    }
    public void removeTimeList(Object o){
        timeList.remove(o);
    }

    public ClockModel() {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }


    public int getMinute() {
        return minute;
    }

    public int getSec() {
        return sec;
    }
    public static ClockModel getInstance(){
        if (instance == null) {
            instance = new ClockModel();
        }
        return instance;
    }

    public ObservableList<ClockModel> getTimeList() {
        return timeList;
    }

    @Override
    public String toString() {
        return hour + " " + minute ;
    }
    //    public String toString(){
//        String result = "";
//        for (int i = 0; i < timeList.size(); i++) {
//            result+= timeList.get(i);
//        }
//        return result;
//
//    }

}
