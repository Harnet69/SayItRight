package com.harnet.basiclayouts.controller;

import android.media.MediaPlayer;

import com.harnet.basiclayouts.R;
import com.harnet.basiclayouts.model.AudioTheque;

import java.lang.reflect.Field;


public class AudioThequeController {
    private AudioTheque audioTheque;
    MainActivity mainActivity;


    public AudioThequeController(MainActivity mainActivity) {
        this.audioTheque = new AudioTheque("France");
        this.mainActivity = mainActivity;
        addAllWords();
//        addAudioSourceFromFolder();
    }

    public AudioTheque getAudioTheque() {
        return audioTheque;
    }

    public void addWordToAydioTheque(String songTitle) {
        audioTheque.getWords().add(songTitle);
    }

    public void addMediaPlayers(MediaPlayer mediaWord) {
        audioTheque.getMediaWords().add(mediaWord);
    }


    // add phrases file names form raw folder
    private void addAllWords() {
        Field[] fields = R.raw.class.getFields();
        for (Field field : fields) {
            addWordToAydioTheque(field.getName());
        }
    }

    public void addAllMediaWords() {
        Field[] fields = R.raw.class.getFields();
        for (Field field : fields) {
            int mediaFile = mainActivity.getResources().getIdentifier(field.getName(), "raw", mainActivity.getPackageName());
            addMediaPlayers(MediaPlayer.create(mainActivity, mediaFile));
        }
    }

    // TODO To leave
    public void addAudioSource(String audioFileTitle, MediaPlayer audioFile){
        audioTheque.getAudioSource().put(audioFileTitle, audioFile);
    }

    private void addAudioSourceFromFolder(){
        Field[] fields = R.raw.class.getFields();
        for (Field field : fields) {
            String audioFileTitle = field.getName();
            int mediaFile = mainActivity.getResources().getIdentifier(field.getName(), "raw", mainActivity.getPackageName());
            addAudioSource(audioFileTitle, MediaPlayer.create(mainActivity, mediaFile));
        }
    }


}
