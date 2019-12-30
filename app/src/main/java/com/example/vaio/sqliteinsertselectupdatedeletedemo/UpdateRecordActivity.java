package com.example.vaio.sqliteinsertselectupdatedeletedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.vaio.sqliteinsertselectupdatedeletedemo.R.id.UpdateBtnSave;
import static com.example.vaio.sqliteinsertselectupdatedeletedemo.R.id.tvId;
import static com.example.vaio.sqliteinsertselectupdatedeletedemo.R.id.tvName;

public class UpdateRecordActivity extends AppCompatActivity {

    MyDataBase sdb;
    EditText edId,edName,edSub;
    Button btnSave;
    String s1,s2,s3;
    String updateId,updateName,updateSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);


       // edId = (EditText) findViewById(R.id.edUpdateId);
        edName = (EditText) findViewById(R.id.edUpdateName);
        edSub = (EditText) findViewById(R.id.edUpdateSubject);
        btnSave = (Button) findViewById(R.id.UpdateBtnSave);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        s1=b.getString("s1");
        s2=b.getString("s2");
        s3=b.getString("s3");
        //edId.setText(s1);
        edName.setText(s2);
        edSub.setText(s3);

        //calling DbAdapter
        sdb = new MyDataBase(this);
        sdb.open();


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s2 = edName.getText().toString();
                s3 = edSub.getText().toString();

                sdb.update(Integer.parseInt(s1),s2, s3);

                Intent intent1 = new Intent(UpdateRecordActivity.this, ShowRecordListActivity.class);
                startActivity(intent1);

            }
        });





    }


}
