package com.harnet.basiclayouts.controller;

import android.app.Activity;
import android.media.MediaPlayer;
import com.harnet.basiclayouts.R;
import com.harnet.basiclayouts.model.AudioTheque;
import java.lang.reflect.Field;


public class AudioThequeController {
    private AudioTheque audioTheque;
    Activity mainActivity;


    public AudioThequeController(Activity mainActivity) {
        this.audioTheque = new AudioTheque();
        this.mainActivity = mainActivity;
        addAllWords();
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

    // add audio files as MediaPlayers to List
    public void addAllMediaWords() {
        Field[] fields = R.raw.class.getFields();
        for (Field field : fields) {
            int mediaFile = mainActivity.getResources().getIdentifier(field.getName(), "raw", mainActivity.getPackageName());
            addMediaPlayers(MediaPlayer.create(mainActivity, mediaFile));
        }
    }
}
