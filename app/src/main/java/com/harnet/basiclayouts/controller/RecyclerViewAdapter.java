package com.harnet.basiclayouts.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.harnet.basiclayouts.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private Context mContext;
    private List<String> words;
    private List<MediaPlayer> files;
    AudioThequeController audioThequeController;
    private int wordsCounter = 0;
    private int filesCounter = 3;

    public RecyclerViewAdapter(Context mContext, AudioThequeController audioThequeController, List<String> words, List<MediaPlayer> files) {
        this.mContext = mContext;
        this.audioThequeController = audioThequeController;
        this.words = words;
        this.files = files;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_buttons, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final int i = position*3;
        if (wordsCounter < words.size() - 3 && filesCounter < files.size() - 3) {
            holder.btn1.setText(words.get(wordsCounter));
            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(i);
                    files.get(i).start();
                }
            });

            holder.btn2.setText(words.get(wordsCounter + 1));
            holder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(i);
                    files.get(i+1).start();
                }
            });
            holder.btn3.setText(words.get(wordsCounter + 2));
            holder.btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(i);
                    files.get(i+2).start();
                }
            });
            wordsCounter += 3;
            filesCounter += 1;
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: !!!");
        return words.size() / 3; // how much repeated view it'll be
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements OnNoteListener {
        ConstraintLayout parent_layout;
        View gridLayout;
        Button btn1;
        Button btn2;
        Button btn3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent_layout = itemView.findViewById(R.id.parent_layout);
            gridLayout = itemView.findViewById(R.id.grid);
            btn1 = itemView.findViewById(R.id.button1);
            btn2 = itemView.findViewById(R.id.button2);
            btn3 = itemView.findViewById(R.id.button3);
//            itemView.setOnClickListener((View.OnClickListener) this);
        }

        @Override
        public void onNoteClick(int position) {

        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }
}
