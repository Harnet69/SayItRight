package com.harnet.basiclayouts.model;

import android.media.MediaPlayer;

import com.harnet.basiclayouts.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AudioTheque{
    private List<String> words = new ArrayList<>();
    private Field[] audioFiles = R.raw.class.getFields();
    private List<MediaPlayer> mediaWords = new ArrayList<>();


    public List<String> getWords() {
        return words;
    }

    public Field[] getAudioFiles() {
        return audioFiles;
    }

    public List<MediaPlayer> getMediaWords() {
        return mediaWords;
    }
}
