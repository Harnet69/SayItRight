package com.harnet.basiclayouts.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.harnet.basiclayouts.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View frenchModule = findViewById(R.id.frIcoView);
        final Intent intent = new Intent(this, FrenchActivity.class);
        frenchModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frenchModule.animate().rotationX(frenchModule.getRotationX()+180).setDuration(500);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        // this code will be executed after 2 seconds
                    }
                }, 550);
            }
        });
    }
}