package com.example.faisal.cse_600;

/**
 * Created by Faisal on 9/30/2016.
 */
public class tv {

    private String title, genre, year,name;
    private int RES;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRES(int RES) {
        this.RES = RES;
    }

    public String getTitle() {

        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public int getRES() {
        return RES;
    }

    public tv(String title, String genre, String year, String name, int RES) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.name = name;
        this.RES = RES;
    }
}
