package com.example.vaio.sqliteinsertselectupdatedeletedemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpleshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh);
        new Handler().postDelayed(new Runnable() {

            public void run() {

                Intent i = new Intent(SpleshActivity.this,InsertActivity.class);
                startActivity(i);

            }
        },1000);
    }
}
