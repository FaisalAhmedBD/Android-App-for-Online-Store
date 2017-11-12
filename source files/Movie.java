package com.example.faisal.cse_600;

/**
 * Created by Lincoln on 15/01/16.
 */
public class Movie {
    private String title, genre, year,name;
    private int RES;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie() {
    }

    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }
    public Movie(String title, String genre, String year, String name, int res) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.RES=res;
        this.name=name;
    }

    public int getRES() {

        return RES;
    }

    public void setRES(int RES) {
        this.RES = RES;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
