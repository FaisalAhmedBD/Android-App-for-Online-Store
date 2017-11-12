package com.example.faisal.cse_600;

/**
 * Created by Faisal on 9/29/2016.
 */
public class nwMovie {
    private String title, genre, year,name,Quantity;
    private int RES;

    public nwMovie(String title, String genre, String year, String name, int RES) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.name = name;
        this.RES = RES;
    }
    public nwMovie(String title, String genre, String year,String quantity, String name, int RES) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.name = name;
        this.RES = RES;
        this.Quantity=quantity;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        this.Quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRES() {
        return RES;
    }

    public void setRES(int RES) {
        this.RES = RES;
    }
}
