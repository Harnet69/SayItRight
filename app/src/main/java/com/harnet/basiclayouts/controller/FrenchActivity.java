package com.harnet.basiclayouts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.harnet.basiclayouts.R;

import java.util.List;

public class FrenchActivity extends AppCompatActivity {
    AudioThequeController audioThequeController = new AudioThequeController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
        audioThequeController.addAllMediaWords(); // add all mediaFile from raw folder to List
        initRecyclerView(); // initialize recycler view

    }

    // init recycler View
    public void initRecyclerView(){
        List<String> words = audioThequeController.getAudioTheque().getWords();
        List<MediaPlayer> files = audioThequeController.getAudioTheque().getMediaWords();
        RecyclerView recyclerView = findViewById(R.id.recyrclerView);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, audioThequeController, words, files);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // back stack (go to parent arrow) controller
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
