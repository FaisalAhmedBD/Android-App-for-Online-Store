package com.example.faisal.cse_600;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class canon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.canon_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Canon Cameras");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
