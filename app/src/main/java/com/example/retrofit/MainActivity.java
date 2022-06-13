package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mJsonTextView;

    //CODIGO DEL MENU
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        // al método inflate() le pasamos el nombre del menú
        getMenuInflater().inflate(R.menu.menu_principal, mimenu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcion_menu){
        // obtiene el Item del menú que se presionó
        int id = opcion_menu.getItemId();

        // -Determinamos a quien corresponde la opción.
        // y en base a ello trabajamos la accion
        //
        // -Respecto al cambio de activity esta trabaja en base
        // a las clases de las activity.

        if(id == R.id.optionIntegrantes){
            Intent ir = new Intent(getApplicationContext(), Integrantes.class);
            startActivity(ir);
        }
        if(id == R.id.optionInformacion){
            Intent ir = new Intent(getApplicationContext(), Informacion.class);
            startActivity(ir);
        }
        if(id == R.id.optionVersion){
            Intent ir = new Intent(getApplicationContext(), VersionApp.class);
            startActivity(ir);
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
    //---TERMINA CODIGO DEL MENU-----------------------------------




    //CODIGO DEL MAINACTIVITY
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        mJsonTextView = findViewById ( R.id.jsonText );
        Button bPost = (Button)this.findViewById(R.id.btpost);
        Button bComments = (Button)this.findViewById(R.id.btcomments);
        Button bAlbums = (Button)this.findViewById(R.id.btalbums);
        Button bUsers = (Button)this.findViewById(R.id.btusers);

        //BOTONES

        bPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent ir = new Intent(getApplicationContext(), postActivity.class);
                startActivity(ir);
            }

        });

        bComments.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent ir = new Intent(getApplicationContext(), commentsActivity.class);
                startActivity(ir);
            }

        });

        bAlbums.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent ir = new Intent(getApplicationContext(), albumsActivity.class);
                startActivity(ir);
            }

        });

        bUsers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent ir = new Intent(getApplicationContext(), usersActivity.class);
                startActivity(ir);
            }

        });

    }
    //---CODIGO DEL MAINACTIVITY-----------------------------------

}