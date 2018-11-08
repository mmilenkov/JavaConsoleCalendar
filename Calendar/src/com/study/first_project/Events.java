package com.study.first_project;

class Events {

    private String start;
    private String end;
    private int month;
    private int date;
    private int year;
    private String Location;

    Events (int year, int month, int date, String start, String end, String location)
    {
        this.year = year;
        this.month = month;
        this.date = date;
        this.Location = location;
        this.start = start;
        this.end = end;
    }

    int getYear() {return year;}
    int getMonth() {return month;}
    int getDate() {return date;}
    String getLocation() {return Location;}
    String getStart() {return start;}
    String getEnd() {return end;}

}
