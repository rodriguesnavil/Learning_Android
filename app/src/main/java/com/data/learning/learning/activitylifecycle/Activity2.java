package com.data.learning.learning.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.data.learning.learning.R;

public class Activity2 extends AppCompatActivity {

    final String Lable="activitylifecycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Log.d(Lable,"act 2 on create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Lable,"activity2 on start");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Lable,"activity2 on resume");
    }

    protected void onPause(){

        super.onPause();
        Log.d(Lable,"activity 2 on pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Lable,"activity 2 on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Lable,"activity 2 on destory");
    }
}
