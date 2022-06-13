package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit.Interface.JsonPlaceHolderApi;
import com.example.retrofit.Modelo.Albums;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class albumsActivity extends AppCompatActivity {
    private TextView mJsonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        mJsonTextView = findViewById ( R.id.jsonText );
        getAlbums ();

    }

    private void getAlbums(){
        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( "https://jsonplaceholder.typicode.com/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create ( JsonPlaceHolderApi.class );
        Call<List<Albums>> call = jsonPlaceHolderApi.getAlbums ();
        call.enqueue ( new Callback<List<Albums>>( ) {
            @Override
            public void onResponse( Call<List<Albums>> call, Response<List<Albums>> response ) {
                if (!response.isSuccessful ()){
                    mJsonTextView.setText ( "codigo: " + response.code () );
                }

                List<Albums> albumsList = response.body ();
                for(Albums comments:albumsList){
                    String content = "";
                    content += "userId:"+ comments.getUserId () + "\n";
                    content += "id:"+ comments.getId () + "\n";
                    content += "title:"+ comments.getTitle () + "\n" + "\n";
                    mJsonTextView.append ( content );
                }
            }

            @Override
            public void onFailure( Call<List<Albums>> call, Throwable t ) {
                mJsonTextView.setText ( t.getMessage () );

            }
        } );
    }




}