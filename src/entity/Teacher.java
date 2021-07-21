package entity;

import util.DateTimeUtil;

import java.util.Date;

public class Teacher {
    private String id;
    private String name;
    private Date date;
    private int numberOfCakes;

    public Teacher() {
    }

    public Teacher(String id, String name, Date date, int numberOfCakes) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.numberOfCakes = numberOfCakes;
    }

    public String toString() {
        return String.format("%2s%5s%2s | %2s%-20s%2s | %2s%-11s%2s | %2s%2s%2s",
                "", id, "",
                "", name, "",
                "", getDateToString(date), "",
                "", numberOfCakes, "");
    }

    public String toStringForSort() {
        return String.format("%2s%5s%2s | %2s%-20s%2s | %2s%-11s%2s",
                "", id, "",
                "", name, "",
                "", numberOfCakes, "");
    }

    public String getDateToString(Date date) {
        return DateTimeUtil.formatDateToString(date);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfCakes() {
        return numberOfCakes;
    }

    public void setNumberOfCakes(int numberOfCakes) {
        this.numberOfCakes = numberOfCakes;
    }
}