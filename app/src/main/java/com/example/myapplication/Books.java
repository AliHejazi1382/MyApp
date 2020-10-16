package com.example.myapplication;

public class Books {
    private String aCategory;
    private String title;
    private String aLang;
    private String author;
    private int year;
    private String photo;
    private double price;

    public String getaCategory() {
        return aCategory;
    }

    public void setaCategory(String aCategory) {
        this.aCategory = aCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getaLang() {
        return aLang;
    }

    public void setaLang(String aLang) {
        this.aLang = aLang;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return title;
    }
}
