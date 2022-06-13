package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit.Interface.JsonPlaceHolderApi;
import com.example.retrofit.Modelo.Comments;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class commentsActivity extends AppCompatActivity {
    private TextView mJsonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        mJsonTextView = findViewById(R.id.jsonText);
        getComments();

    }

    private void getComments() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Comments>> call = jsonPlaceHolderApi.getComments();
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (!response.isSuccessful()) {
                    mJsonTextView.setText("codigo: " + response.code());
                }

                List<Comments> commentsList = response.body();
                for (Comments comments : commentsList) {
                    String content = "";
                    content += "userId:" + comments.getUserId() + "\n";
                    content += "id:" + comments.getId() + "\n";
                    content += "name:" + comments.getName() + "\n";
                    content += "email:" + comments.getEmail() + "\n";
                    content += "body:" + comments.getBody() + "\n\n";
                    mJsonTextView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                mJsonTextView.setText(t.getMessage());

            }
        });
    }



}