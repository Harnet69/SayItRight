package com.harnet.basiclayouts.model;

import android.media.MediaPlayer;

public class Btn {
    private String textTitle;
    private MediaPlayer resource;

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public Btn(MediaPlayer resource) {
        this.resource = resource;
    }
}
