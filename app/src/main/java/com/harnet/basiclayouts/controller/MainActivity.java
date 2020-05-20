package com.harnet.basiclayouts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.media.MediaPlayer;
import android.os.Bundle;
import com.harnet.basiclayouts.R;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    AudioThequeController audioThequeController = new AudioThequeController(this);
    public static final String BTNS_QUANTITY = "BTNS_QUANTITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioThequeController.addAllMediaWords(); // add all mediaFile from raw folder to List
        initRecyclerView();

    }

    // init recycler View
    public void initRecyclerView(){
        List<String> words = audioThequeController.getAudioTheque().getWords();
        List<MediaPlayer> files = audioThequeController.getAudioTheque().getMediaWords();
        RecyclerView recyclerView = findViewById(R.id.recyrclerView);
    }
}