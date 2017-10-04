package com.data.learning.learning;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class UiComponent extends AppCompatActivity{

    private RadioButton gender;
    private static RadioGroup radio;
    Calendar dateTime=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_component);
        radio= (RadioGroup) findViewById(R.id.gendergroup);
        change();
    }

    public void submit(View view){
        int select=radio.getCheckedRadioButtonId();
        gender= (RadioButton) findViewById(select);
        if(gender==null){
            Toast.makeText(this, "No item selected", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "This " + gender.getText(), Toast.LENGTH_LONG).show();

        }
    }

    public void clear(View view){

    }
    public void change(){
        RatingBar rate = (RatingBar) findViewById(R.id.rateus);
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("rating",String.valueOf(rating)+ String.valueOf(fromUser));
                Toast.makeText(UiComponent.this,String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });

    }
    DatePickerDialog.OnDateSetListener datelistner= new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Button b1= (Button) findViewById(R.id.dob);
            b1.setText(dayOfMonth+"/"+month+"/"+year);
        }
    };
    public void datepicker(View view){
        new DatePickerDialog(this,datelistner,dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }
    TimePickerDialog.OnTimeSetListener timelistner=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Button temp= (Button) findViewById(R.id.starttime);
            temp.setText(hourOfDay+":"+minute);
        }
    };
    public void timepicker(View view){
        new TimePickerDialog(this, timelistner,dateTime.get(Calendar.HOUR_OF_DAY),dateTime.get(Calendar.MINUTE),true).show();
    }
}
