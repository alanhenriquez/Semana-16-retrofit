package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit.Interface.JsonPlaceHolderApi;
import com.example.retrofit.Modelo.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class usersActivity extends AppCompatActivity {
    private TextView mJsonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        mJsonTextView = findViewById ( R.id.jsonText );
        getUsers ();

    }

    private void getUsers(){
        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( "https://jsonplaceholder.typicode.com/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create ( JsonPlaceHolderApi.class );
        Call<List<Users>> call = jsonPlaceHolderApi.getUsers ();
        call.enqueue ( new Callback<List<Users>>( ) {
            @Override
            public void onResponse( Call<List<Users>> call, Response<List<Users>> response ) {
                if (!response.isSuccessful ()){
                    mJsonTextView.setText ( "codigo: " + response.code () );
                }

                List<Users> usersList = response.body ();
                for(Users users:usersList){
                    String content = "";
                    content += "id:"+ users.getId () + "\n";
                    content += "name:"+ users.getName () + "\n";
                    content += "userName:"+ users.getUsername () + "\n";
                    content += "email:"+ users.getEmail () + "\n";
                    content += "addres:"+ users.getAddress () + "\n";
                    content += "phone:"+ users.getPhone () + "\n";
                    content += "website:"+ users.getWebsite () + "\n";
                    content += "company:"+ users.getCompany () + "\n" + "\n";
                    mJsonTextView.append ( content );
                }
            }

            @Override
            public void onFailure( Call<List<Users>> call, Throwable t ) {
                mJsonTextView.setText ( t.getMessage () );

            }
        } );
    }


}