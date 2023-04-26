package com.example.activitytofragment;

public class DataClass {
    final int images;
    final String text;

    public DataClass(int images, String text) {
        this.images = images;
        this.text = text;
    }

    public int getImages(){
        return  images;
    }
    public String getText(){
        return text;

    }
}
