package com.example.vaio.sqliteinsertselectupdatedeletedemo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowRecordListActivity extends AppCompatActivity {


    RecyclerView rv;
    MyAdapter m;
    MyDataBase db;
    Cursor c;

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.row,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final MyAdapter.ViewHolder holder, int position) {
            c.moveToPosition(position);
            holder.tv1.setText(c.getString(0));
            holder.tv2.setText(c.getString(1));
            holder.tv3.setText(c.getString(2));
            final String Rid,Rname,Rsub;
            Rid=c.getString(0);
            Rname=c.getString(1);
            Rsub=c.getString(2);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ShowRecordListActivity.this,DisplayRowInfoActivity.class);
                    intent.putExtra("id",Rid);
                    intent.putExtra("name",Rname);
                    intent.putExtra("sub",Rsub);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return c.getCount();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv1,tv2,tv3;
            public ViewHolder(View itemView) {
                super(itemView);
                tv1 = (TextView) itemView.findViewById(R.id.tvId);
                tv2 = (TextView)itemView.findViewById(R.id.tvName);
                tv3 = (TextView)itemView.findViewById(R.id.tvSubject);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_record_list);


        rv = (RecyclerView) findViewById(R.id.rv);
        m = new MyAdapter();
        db = new MyDataBase(getApplication());
        db.open();
        c=db.querystudent();
        rv.setAdapter(m);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);



    }
}
