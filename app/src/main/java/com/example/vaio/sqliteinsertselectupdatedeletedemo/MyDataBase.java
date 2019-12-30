package com.example.vaio.sqliteinsertselectupdatedeletedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 10/9/2019.
 */

public class MyDataBase {
    MyHelper mh;
    SQLiteDatabase sdb;
    public static String dbTable = "student";


    public MyDataBase(Context c){
        mh = new MyHelper(c,"techpalle.db",null,1);
    }
    public void open(){
        sdb = mh.getWritableDatabase();
    }
    /*public void insertstudent(String name, String subject){
        ContentValues cv = new ContentValues();

        cv.put("name",name);
        cv.put("subject",subject);
        sdb.insert("student",null,cv);
    }*/

    //insert data
    public void insertstudent(String text2,String text3) {

        sdb.execSQL("INSERT INTO student (name,subject) VALUES('" + text2 + "','" + text3 + "')");

    }

    //edit data
    public void update(int id,String text2,String text3) {
        sdb.execSQL("UPDATE "+dbTable+" SET name='"+text2+"', subject='"+text3+"'  WHERE _id=" + id);
    }

    //delete data
    public void delete(int id) {
        sdb.execSQL("DELETE FROM "+dbTable+" WHERE _id="+id);
    }


    //select data
    public Cursor querystudent(){
        Cursor c;
        c=sdb.query("student",null,null,null,null,null,null);
        return c;
    }

    public void closed(){
        sdb.close();
    }

    public class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table student(_id integer primary key autoincrement,name text,subject text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
