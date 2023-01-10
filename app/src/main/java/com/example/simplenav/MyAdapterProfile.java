package com.example.simplenav;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterProfile extends RecyclerView.Adapter<FollowViewHolder>{

        private LayoutInflater mInflater;
        ArrayList<Twok> twoks;
        public MyAdapterProfile(Context context,ArrayList<Twok> mt){
            this.mInflater = LayoutInflater.from(context);
            this.twoks = mt;
        }

        @NonNull
        @Override
        public FollowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("size",twoks.size()+"");
            View view = mInflater.inflate(R.layout.single_row3, parent,false);
            return new FollowViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FollowViewHolder holder, int position) {

            Twok twok = twoks.get(position);
            holder.updateContent(twok);
        }

        @Override
        public int getItemCount() {
            return twoks.size();
        }
    }

