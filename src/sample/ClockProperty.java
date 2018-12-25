package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClockProperty extends ClockModel {
    private SimpleIntegerProperty hour;
    private SimpleIntegerProperty minute;
    private int hourStr;
    private int minuteStr;

    public ClockProperty(int hourStr, int minuteStr) {
        this.hour = new SimpleIntegerProperty(hourStr);
        this.minute = new SimpleIntegerProperty(minuteStr);
        this.hourStr = hourStr;
        this.minuteStr = minuteStr;
    }

    @Override
    public int getHour() {
        return hour.get();
    }

    public SimpleIntegerProperty hourProperty() {
        return hour;
    }

    @Override
    public int getMinute() {
        return minute.get();
    }

    public SimpleIntegerProperty minuteProperty() {
        return minute;
    }

    public int getHourStr() {
        return hourStr;
    }

    public int getMinuteStr() {
        return minuteStr;
    }

    @Override
    public String toString() {
        return hourStr + " " + minuteStr;
    }
}

