package com.example.t201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class Practica_3_Activity extends AppCompatActivity {
private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica3);
        actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}