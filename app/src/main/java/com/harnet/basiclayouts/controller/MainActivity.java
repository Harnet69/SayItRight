package com.harnet.basiclayouts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.harnet.basiclayouts.R;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    AudioThequeController audioThequeController = new AudioThequeController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addWordToBtn();
        audioThequeController.addAllMediaWords(); // add all mediaFile from raw folder to List
//        System.out.println(audioThequeController.getAudioTheque().getMediaWords());
//        audioThequeController.getAudioTheque().getMediaWords().get(0).start();


//        final MediaPlayer doYou = MediaPlayer.create(this, R.raw.do_you_speak_english);
//        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                doYou.start();
////                addWordToBtn();
//            }
//        });
    }

    // add text to buttons
    public void addWordToBtn() {
        GridLayout yourLayout = findViewById(R.id.grid);

        for (int i = 0; i < yourLayout.getChildCount(); i++) {
            View subView = yourLayout.getChildAt(i);
            final Field wordToAdd = audioThequeController.getAudioTheque().getAudioFiles()[i];
            if (subView instanceof Button) {
                ((Button) subView).setText(wordToAdd.getName());
                final int finalI = i;
                subView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        audioThequeController.getAudioTheque().getMediaWords().get(finalI).start();
                    }
                });
            }
        }
    }
}
