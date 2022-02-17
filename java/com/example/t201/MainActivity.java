package com.example.t201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //INICIALIZAR BARRA
        actionBar = getSupportActionBar();
        //INDICAR BOTON HOME
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() ==  android.R.id.home){
            //METODO FINISH REGERESA A PANTALLA ANTERIOR
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}