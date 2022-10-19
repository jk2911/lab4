package maxim.goy.lab4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Club implements Serializable {
    private String name;
    private Calendar date;
    private String coach;
    private String stadium;



    public Club(String name, Calendar date, String coach, String stadium) {
        this.name = name;
        this.date = date;
        this.coach = coach;
        this.stadium = stadium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String toString() {
        String str = getName();
        str += "\n" + getStringDate();
        str += "\n" + getCoach() + "\n" + getStadium();
        return str;
    }

    public String getStringDate() {
        int day = date.get(Calendar.DATE);
        int month = date.get(Calendar.MONTH) + 1;
        int year = date.get(Calendar.YEAR);
        return (day < 10 ? "0" + day : day) + "." +
                (month < 10 ? "0" + month : month) + "." +
                year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass())
            return false;

        Club c = (Club) o;
        if (name.equals(c.name) && coach.equals(c.coach) && stadium.equals(c.stadium))
            return true;

        return false;
    }
}
