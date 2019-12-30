package com.example.vaio.sqliteinsertselectupdatedeletedemo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {


    EditText InsertName,InsertSubject;
    Button btnInsert,btnShowlist;
    MyDataBase db;
    Cursor c;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        InsertName = (EditText) findViewById(R.id.InsertName);
        InsertSubject = (EditText) findViewById(R.id.InsertSubject);
        btnInsert = (Button) findViewById(R.id.InsertbtnInsert);
        btnShowlist = (Button) findViewById(R.id.InsertbtnShowlist);
        db = new MyDataBase(getApplication());
        db.open();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = InsertName.getText().toString();
                String subject = InsertSubject.getText().toString();
                db.insertstudent(name,subject);
                InsertName.setText("");
                InsertSubject.setText("");
                InsertName.requestFocus();
                Intent i = new Intent(InsertActivity.this,ShowRecordListActivity.class);
                startActivity(i);
            }
        });

        btnShowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertActivity.this,ShowRecordListActivity.class);
                startActivity(intent);
            }
        });


    }
}
