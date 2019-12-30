package com.example.vaio.sqliteinsertselectupdatedeletedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayRowInfoActivity extends AppCompatActivity {


    public TextView displayId,displayName,displaySub;
    Button btnUpdate,btnDelete;
    //String Displayid,Displayname,sub;
    public String s1,s2,s3;
    MyDataBase sdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_row_info);


        displayId = (TextView) findViewById(R.id.displayId);
        displayName = (TextView) findViewById(R.id.displayName);
        displaySub = (TextView) findViewById(R.id.displaySub);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        btnDelete = (Button) findViewById(R.id.buttonDelete);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        s1=b.getString("id");
        s2=b.getString("name");
        s3=b.getString("sub");
        displayId.setText(s1);
        displayName.setText(s2);
        displaySub.setText(s3);
        //btn

        //calling DbAdapter
        sdb = new MyDataBase(this);
        sdb.open();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DisplayRowInfoActivity.this,UpdateRecordActivity.class);
                intent.putExtra("s1",s1);
                intent.putExtra("s2",s2);
                intent.putExtra("s3",s3);
                startActivity(intent);
            }
        });
        //btn

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                sdb.delete(Integer.parseInt(s1));
                //Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();

                //Edit for go to mainactivity after delete record
                Intent i = new Intent(DisplayRowInfoActivity.this, ShowRecordListActivity.class);
                startActivity(i);
                //end
            }
        });

    }
}
