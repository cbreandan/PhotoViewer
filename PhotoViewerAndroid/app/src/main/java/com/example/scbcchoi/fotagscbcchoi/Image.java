package com.example.scbcchoi.fotagscbcchoi;

public class Image {
    public int source;
    public float rating;

    public Image(int imageSource) {
        for (int i=0; i<5; i++){
            source = imageSource;
        }
        rating = 0;
    }
}
