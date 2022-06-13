package com.example.retrofit.Interface;

import com.example.retrofit.Modelo.Albums;
import com.example.retrofit.Modelo.Comments;
import com.example.retrofit.Modelo.Posts;
import com.example.retrofit.Modelo.Users;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts") Call<List<Posts>> getPost();
    @GET("comments") Call<List<Comments>> getComments();
    @GET("albums") Call<List<Albums>> getAlbums();
    @GET("users") Call<List<Users>> getUsers();

}
