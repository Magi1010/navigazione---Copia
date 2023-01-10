package com.example.simplenav;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PictureRepository {
    private static Integer uidpic;
   // private static Picture pic = null;
    static void initializePicture(Integer uid,Sid sid, Context x, PictureInizializeListener listener) {
        SharedPreferences settings = x.getSharedPreferences("PictureDettails", 0);
        SharedPreferences settingspv = x.getSharedPreferences("pvDettails", 0);
        String BASE_URL = "https://develop.ewlab.di.unimi.it/mc/twittok/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface registerAPI = retrofit.create(ApiInterface.class);

            uidpic = uid;
            Call<Picture> call = registerAPI.getPicture(sid.getSid(), uid);
            call.enqueue(new Callback<Picture>() {
                @Override
                public void onResponse(Call<Picture> call, Response<Picture> response) {
                    Log.d("picture", response.body().getPicture()+"");
                    Picture picc = new Picture(response.body().getName(),response.body().getPversion(),response.body().getPicture());


                    if(settings.getString(uidpic.toString(),"").equals(null)){
                        SharedPreferences.Editor editor =  settings.edit();
                        editor.putString(uidpic.toString(), response.body().getPicture());
                        editor.commit();
                        SharedPreferences.Editor editorpv =  settingspv.edit();
                        editorpv.putString(uidpic.toString(), response.body().getPversion());
                        editorpv.commit();

                    }else{
                        if(!settingspv.getString(uidpic.toString(),"").equals(response.body().getPversion())){
                            SharedPreferences.Editor editor =  settings.edit();
                            editor.putString(uidpic.toString(), response.body().getPicture());
                            editor.commit();
                            SharedPreferences.Editor editorpv =  settingspv.edit();
                            editorpv.putString(uidpic.toString(), response.body().getPversion());
                            editorpv.commit();

                        }
                    }


                    Log.d("Immagazino",settings.getString(uidpic.toString(),"")+"");
                    Log.d("Immagazino",settingspv.getString(uidpic.toString(),"")+"");
                    listener.onSidPicture(picc);





                }

                @Override
                public void onFailure(Call<Picture> call, Throwable t) {
                    t.printStackTrace();
                }
            });



    }






}
