package com.harnet.basiclayouts.controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.harnet.basiclayouts.R;

import java.lang.reflect.Field;
import java.util.Objects;

public class Page2 extends AppCompatActivity {
    AudioThequeController audioThequeController = new AudioThequeController(this);
    public static final String BTNS_QUANTITY = "BTNS_QUANTITY";
    public int btns_qtt;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Intent intent = getIntent();
        String learnedWords = intent.getStringExtra("BTNS_QUANTITY");
        assert learnedWords != null;
        btns_qtt = Integer.parseInt(learnedWords);

        btns_qtt += countBtnsInGrid();
        addWordToBtn();
        audioThequeController.addAllMediaWords(); // add all mediaFile from raw folder to List
    }

    // add text to buttons
    @SuppressLint("SetTextI18n")
    public void addWordToBtn() {
        GridLayout BtnsGrid = findViewById(R.id.grid);

        for (int i = 0; i < BtnsGrid.getChildCount(); i++) {
            View subView = BtnsGrid.getChildAt(i);
            final Field wordToAdd = audioThequeController.getAudioTheque().getAudioFiles()[i];
            if (i < BtnsGrid.getChildCount() - 1) {
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
            } else {
                if (subView instanceof Button) {
                    ((Button) subView).setText("next page");
                    subView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            goToNextPage();
                        }
                    });
                }
            }
        }
    }

    private int countBtnsInGrid() {
        GridLayout yourLayout = findViewById(R.id.grid);
        int btnCounter = 0;

        for (int i = 0; i < yourLayout.getChildCount(); i++) {
            View subView = yourLayout.getChildAt(i);
            if (i < yourLayout.getChildCount()) {
                if (subView instanceof Button) {
                    btnCounter++;
                }
            }
        }
        return btnCounter-1;
    }

    public void goToNextPage() {
        Intent intent = new Intent(this, Page2.class);
        String message = String.valueOf(btns_qtt);
        intent.putExtra(BTNS_QUANTITY, message);
        startActivity(intent);
    }
}
