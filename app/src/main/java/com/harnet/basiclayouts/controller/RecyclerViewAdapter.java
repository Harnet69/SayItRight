package com.harnet.basiclayouts.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    public RecyclerViewAdapter(Context mContext, List<String> words, List<MediaPlayer> files) {
        this.mContext = mContext;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.btn1.setText(words.get(0));
        holder.btn2.setText(words.get(1));
        holder.btn3.setText(words.get(2));
        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click", "Click on Btn1!");
            }
        });
        
        holder.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click", "Click on Btn2!");
            }
        });
        
        holder.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click", "Click on Btn3!");
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: !!!");
        return 10; // how much repeated view it'll be
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
        }
    }
}