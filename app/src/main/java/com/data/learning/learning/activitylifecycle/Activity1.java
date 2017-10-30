package com.data.learning.learning.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.data.learning.learning.R;

public class Activity1 extends AppCompatActivity {
    final String Lable="lifecycle";
    // Execute when only once when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        Log.d(Lable,"activity1 On create");
    }
   // Execute more than one time
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Lable,"activity1 on start");

    }
// Excutes after on start
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Lable,"activity1 on resume");

    }

    protected void onPause(){

        super.onPause();
        Log.d(Lable,"activity1 on pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Lable,"activity1 on stop");
    }
// Execute when activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Lable,"activity1 on destory");
    }
// Excute when button is pressed and jumps to another activity
    public void go(View view){
        Intent intent=new Intent(this,Activity2.class);
        intent.putExtra("name","thompson");
        intent.putExtra("age","21");
        startActivity(intent);
    }
}
