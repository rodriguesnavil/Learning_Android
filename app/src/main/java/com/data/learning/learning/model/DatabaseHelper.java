package com.data.learning.learning.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Thompson on 31-08-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private final String TableName="COLLEGE";
    private final String ID="id";
    private final String NAME="name";
    private final String PHONE="phone";
    private final String EMAIL="email";
     String Databasename="DATA";
    public DatabaseHelper(Context context) {
        super(context,"DATA", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table  COLLEGE  (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(25) ,phone varchar(12), email varchar(25))";
        db.execSQL(query);

        /*
        create table  college  (id INTEGER PRIMARY KEY, name varchar(25) ,phone varchar(12), email varchar(25))*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String query; query = "DROP TABLE IF EXISTS COLLEGE";
        database.execSQL(query);
        onCreate(database);
    }
   
    // Function select a particular name
    public Cursor selectdata(String name){
        SQLiteDatabase database=this.getReadableDatabase();
        String array[]=new String[1];
        array[0]=name;
        return database.rawQuery("select * from "+TableName+" where ?=?",new String[]{"id",name});

    }
   // Check login
    public Cursor login(String name){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor res=database.rawQuery("select * from "+TableName+" where id=?",new String[]{name});
        return res;
    }

      // Get the content of the row
    public Cursor selectdata(){
        SQLiteDatabase database=this.getReadableDatabase();
        return database.rawQuery("select * from "+TableName,null);
    }
   // Insert data into datbase 
    public void insertData(String name,String phone,String email){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contents=new ContentValues();
        contents.put(NAME,name);
        contents.put(PHONE,phone);
        contents.put(EMAIL,email);
        long i=database.insert(TableName,null,contents);


    }
//Delete data into database
    public void delete(String id){
        SQLiteDatabase database=this.getWritableDatabase();
        database.delete(TableName,id,null);
    }
//Upate data 
    public void updatedata(String id,String name,String phone,String email ){
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,name);
        values.put(PHONE,phone);
        values.put(EMAIL,email);
        database.update(TableName,values,"id="+id,null);
    }

}
