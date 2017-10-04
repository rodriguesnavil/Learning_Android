package com.data.learning.learning;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class UiComponent extends AppCompatActivity{

    private  String alertselected;
    private RadioButton gender;
    private static RadioGroup radio;
    private static AutoCompleteTextView country;
    private static ArrayList<String> selectedcountry;
    Calendar dateTime=Calendar.getInstance();
    CoordinatorLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_component);
        radio= (RadioGroup) findViewById(R.id.gendergroup);
        setup();
        change();
        layout= (CoordinatorLayout) findViewById(R.id.coordinator);
        selectedcountry=new ArrayList<String>();
    }

//    setup the auto complete text view
    public void setup(){
        int layoutItem=android.R.layout.simple_dropdown_item_1line;
        String [] countryname=getResources().getStringArray(R.array.countries_array);
        List<String> name= Arrays.asList(countryname);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,layoutItem,name);
        country= (AutoCompleteTextView) findViewById(R.id.country);
        country.setAdapter(adapter);

    }

    // action for submit button
    public void submit(View view){
        int select=radio.getCheckedRadioButtonId();
        gender= (RadioButton) findViewById(select);
        if(gender==null){
            Toast.makeText(this, "No item selected", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "This " + gender.getText(), Toast.LENGTH_LONG).show();

        }
    }

    // action for clear button
    public void clear(View view){
            Snackbar.make(layout,"You have pressed clear button",Snackbar.LENGTH_LONG).show();
    }

    //action for Rating Bar
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

    // action for Datepicker
    public void datepicker(View view){
        new DatePickerDialog(this,datelistner,dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    // action for Timepicker
    public void timepicker(View view){
        TimePickerDialog.OnTimeSetListener timelistner=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Button temp= (Button) findViewById(R.id.starttime);
                temp.setText(hourOfDay+":"+minute);
            }
        };
        new TimePickerDialog(this, timelistner,dateTime.get(Calendar.HOUR_OF_DAY),dateTime.get(Calendar.MINUTE),true).show();
    }

    //code for simple alert
    public void showalert(View view){

        AlertDialog.Builder builder=new AlertDialog.Builder(UiComponent.this);
        builder.setTitle("Simple Alert");
        builder.setMessage("Your message will come here");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You have selected positive button",Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You have selected NO button ",Toast.LENGTH_LONG).show();
            }
        });

        String [] choice={"Exit","Cancel"};
        builder.setItems(choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    finish();
                }
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();


    }

    //code for multiple choice
    public void showMultipleAlert(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(UiComponent.this);
        builder.setTitle("Multiple Select Alert");


        final String [] data=getResources().getStringArray(R.array.countries_array);
        final boolean selected[]=new boolean[data.length];
        builder.setMultiChoiceItems(data,selected, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    selectedcountry.add(data[which]);
                }else{
                    selectedcountry.remove(data[which]);
                }
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You have selected positive button "+selectedcountry,Toast.LENGTH_LONG).show();
                selectedcountry.removeAll(selectedcountry);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You have selected NO button ",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    public void showSingleAlert(View view){

        AlertDialog.Builder builder=new AlertDialog.Builder(UiComponent.this);
        builder.setTitle("Single Alert");
        final String [] data=getResources().getStringArray(R.array.countries_array);

        builder.setSingleChoiceItems(data, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertselected=""+data[which];
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You have selected positive button "+alertselected,Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You have selected NO button ",Toast.LENGTH_LONG).show();
            }
        });



        AlertDialog alertDialog=builder.create();
        alertDialog.show();


    }
}
