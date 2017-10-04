package com.data.learning.learning;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.data.learning.learning.model.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper=new DatabaseHelper(MainActivity.this);
        databaseHelper.insertData("frcrce","8149","crce@email.com");
        databaseHelper.insertData("frcrce","9922025939","crce@email.com");
        Cursor res=databaseHelper.selectdata();
        String name="",rollno="",email="",phone="";
        while(res.moveToNext()){
            rollno=res.getString(0);
            name=res.getString(1);
            phone=res.getString(res.getColumnIndex("phone"));
            email=res.getString(res.getColumnIndex("email"));
        }
        Toast.makeText(this, ""+rollno+" "+name+" "+phone+" "+email, Toast.LENGTH_SHORT).show();
        Log.d("DATA","before update "+rollno+" "+name+" "+phone+" "+email);
        databaseHelper.updatedata(rollno,"frcrce","8149","crce@email.com");
        res=databaseHelper.selectdata(rollno);
        while(res.moveToNext()){
            rollno=res.getString(0);
            name=res.getString(1);
            phone=res.getString(res.getColumnIndex("phone"));
            email=res.getString(res.getColumnIndex("email"));
        }
        Log.d("DATA","after update "+rollno+" "+name+" "+phone+" "+email);

        databaseHelper.delete(rollno);
        databaseHelper.insertData("frcrce","8149","crce@email.com");
        databaseHelper.insertData("frcrce","9922025939","crce@email.com");
        res=databaseHelper.selectdata();
        while(res!=null && res.moveToNext()){
            rollno=res.getString(0);
            name=res.getString(1);
            phone=res.getString(res.getColumnIndex("phone"));
            email=res.getString(res.getColumnIndex("email"));
            Log.d("DATABASE","before delete "+rollno+" "+name+" "+phone+" "+email);
        }
        res=databaseHelper.login("1 or '1'='1'");
        if(res!=null){
            Toast.makeText(this, "res", Toast.LENGTH_SHORT).show();
            while(res.moveToNext()){
                rollno=res.getString(res.getColumnIndex("id"));
                name=res.getString(res.getColumnIndex("name"));
                Toast.makeText(this,""+rollno+" "+name,Toast.LENGTH_LONG).show();
            }
        }
    }
}
