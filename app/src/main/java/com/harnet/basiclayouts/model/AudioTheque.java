package com.harnet.basiclayouts.model;

import android.media.MediaPlayer;

import com.harnet.basiclayouts.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AudioTheque{
    private String name;
    private HashMap<String, MediaPlayer> audioSource = new HashMap<>();

    public AudioTheque(String name) {
        this.name = name;
    }

    // TODO for deleting
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

    // TODO to leave
    public HashMap<String, MediaPlayer> getAudioSource() {
        return audioSource;
    }
}
