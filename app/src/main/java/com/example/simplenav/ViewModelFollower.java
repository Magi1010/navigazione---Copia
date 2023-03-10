package com.example.simplenav;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ViewModelFollower {

    private MutableLiveData<List<Twok>> follower;




    public ViewModelFollower(){
        follower = new  MutableLiveData<>();


    }


    public MutableLiveData<List<Twok>> getListFollower(Sid sid, Context x){
        FollowerRepository.initializeFollower(sid,follow->{
            SharedPreferences settings = x.getSharedPreferences("PictureDettails", 0);
            List<Twok> lista = new ArrayList<>();
            for (int i = 0; i < follow.size(); i++) {
                Log.d("followimma",settings.getString(follow.get(i).getUid().toString(),"")+"");
                String piicture = settings.getString(follow.get(i).getUid().toString(),"");

                Twok t = new Twok(follow.get(i).getUid(),follow.get(i).getName(),piicture,follow.get(i).getPversion());
                lista.add(t);
            }
            follower.setValue(lista);

        });
        return follower;
    }



}
