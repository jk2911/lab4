package maxim.goy.lab4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Club implements Serializable {
    private String name;
    private Calendar date;
    private String coach;
    private String stadium;
    private ArrayList<String> tournament;

    public Club(String name, Calendar date, String coach, String stadium, ArrayList<String> tournament) {
        this.name = name;
        this.date = date;
        this.coach = coach;
        this.stadium = stadium;
        this.tournament = tournament;
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

    public ArrayList<String> getTournament() {
        return tournament;
    }

    public void setTournament(ArrayList<String> tournament) {
        this.tournament = tournament;
    }

    public String toString() {
        String str = getName();
        int day = date.get(Calendar.DATE);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);
        str += "\n" + (day < 10 ? "0" + day : day) + "." +
                (month < 10 ? "0" + month : month) + "." +
                year;
        str += "\n" + getCoach() + "\n" + getStadium();
        for (String i : getTournament())
            str += "\n   " + i;
        return str;
    }
}
