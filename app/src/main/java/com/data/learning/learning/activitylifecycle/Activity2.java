package com.data.learning.learning.activitylifecycle;

import android.content.Intent;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.data.learning.learning.R;

public class Activity2 extends AppCompatActivity {

    final String Lable="activitylifecycle";
    private static TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent in=getIntent();
        Bundle bundle=in.getExtras();
        String s=""+bundle.get("age");
        RelativeLayout rel= (RelativeLayout) findViewById(R.id.actlayout);
        Snackbar.make(rel,s,Snackbar.LENGTH_LONG).show();
        String st=in.getStringExtra("name");
        text= (TextView) findViewById(R.id.textdata);
        text.setText("name: "+st+"\nage: "+s);
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
