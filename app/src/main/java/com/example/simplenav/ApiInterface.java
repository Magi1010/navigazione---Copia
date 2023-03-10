package com.example.simplenav;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
   @POST("register")
   Call<Sid> getSid();
   @FormUrlEncoded
   @POST("getTwok")
   Call<Twok> getTwok(@Field("sid") String sid, @Field("uid") Integer uid);
   @FormUrlEncoded
   @POST("getPicture")
   Call<Picture> getPicture(@Field("sid") String sid, @Field("uid") Integer uid);
   @FormUrlEncoded
   @POST("follow")
   Call<Twok> follow(@Field("sid") String sid, @Field("uid") Integer uid);
   @FormUrlEncoded
   @POST("unfollow")
   Call<Twok> unfollow(@Field("sid") String sid, @Field("uid") Integer uid);
   @FormUrlEncoded
   @POST("isFollowed")
   Call<Followed> isFollowed(@Field("sid") String sid, @Field("uid") Integer uid);
   @FormUrlEncoded
   @POST("getFollowed")
   Call<List<Twok>> getFollowed(@Field("sid") String sid);

}