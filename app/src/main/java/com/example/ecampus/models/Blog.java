package com.example.ecampus.models;

public class Blog {
    private String image;
    private String title;
    private String desc;
    private String date;

    public Blog(String image, String title, String desc, String date) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.date = date;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Blog(){

    }
}
