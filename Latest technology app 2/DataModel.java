package com.example.mygalleryapp2;

public class DataModel {

    private int imageResource;
    private String imageName;

    public DataModel(int imageResource, String imageName){
        this.imageName = imageName;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getImageName() {
        return imageName;
    }
}
