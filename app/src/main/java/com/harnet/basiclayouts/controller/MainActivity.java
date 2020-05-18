package com.harnet.basiclayouts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.harnet.basiclayouts.R;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    AudioThequeController audioThequeController = new AudioThequeController(this);
    public static final String BTNS_QUANTITY = "BTNS_QUANTITY";
    public int btns_qtt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if(intent.getStringExtra("BTNS_QUANTITY") != null){
            String learnedWords = intent.getStringExtra("BTNS_QUANTITY");
            assert learnedWords != null;
            btns_qtt = Integer.parseInt(learnedWords);
        }

        addWordToBtn();
        audioThequeController.addAllMediaWords(); // add all mediaFile from raw folder to List
    }

    // add text to buttons
    @SuppressLint("SetTextI18n")
    public void addWordToBtn() {
        GridLayout BtnsGrid = findViewById(R.id.grid);
        int audioFilesQtt = audioThequeController.getAudioTheque().getAudioFiles().length;

        for (int i = 0, k = btns_qtt; i < BtnsGrid.getChildCount(); i++, k++) {
            View subView = BtnsGrid.getChildAt(i);
            if (i < BtnsGrid.getChildCount() - 2 && k < audioFilesQtt) {
                if (subView instanceof Button) {
                    final Field wordToAdd = audioThequeController.getAudioTheque().getAudioFiles()[k];
                    ((Button) subView).setText(wordToAdd.getName());
                    final int finalK = k;
                    subView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            audioThequeController.getAudioTheque().getMediaWords().get(finalK).start();
                        }
                    });
                }
            }
            else if (i == BtnsGrid.getChildCount() - 2 && btns_qtt != 0) {
                if (subView instanceof Button) {
                    ((Button) subView).setText("prev page");
                    subView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            goToPrevPage();
                        }
                    });
                }
            }
            else if (i == BtnsGrid.getChildCount()-1&& k < audioFilesQtt) {
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
        return btnCounter-2;
    }

// TODO Ask Adam if I have to unite these two methods
    public void goToPrevPage() {
        btns_qtt -= countBtnsInGrid();
        Intent intent = new Intent(this, MainActivity.class);
        String message = String.valueOf(btns_qtt);
        intent.putExtra(BTNS_QUANTITY, message);
        startActivity(intent);
    }

    public void goToNextPage() {
        btns_qtt += countBtnsInGrid();
        Intent intent = new Intent(this, MainActivity.class);
        String message = String.valueOf(btns_qtt);
        intent.putExtra(BTNS_QUANTITY, message);
        startActivity(intent);
    }
}