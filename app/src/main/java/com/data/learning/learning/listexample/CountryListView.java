package com.data.learning.learning.listexample;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.data.learning.learning.R;

import java.sql.Array;
import java.util.ArrayList;
// Created class to implement listview 
public class CountryListView extends AppCompatActivity {

    // Created private list of country 
    private static String [] country;
    private static ListView listView;
    private static EditText searchtext;
    private static ArrayAdapter adapter;
    private static RelativeLayout layout;
    private static Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list_view);
        searchtext= (EditText) findViewById(R.id.searchtext);
        country=getResources().getStringArray(R.array.countries_array);
         adapter=new ArrayAdapter<String>(this,R.layout.listviewrow,country);
        listView= (ListView) findViewById(R.id.countrylist);
        listView.setAdapter(adapter);
        layout= (RelativeLayout) findViewById(R.id.rellistview);
        click();
    }

//Listerner added for listview 
    public void click(){
        //Executes when a row in list view is clicked

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(layout,"You have clicked "+country[position],Snackbar.LENGTH_LONG).show();
            }
        });
       //Executes when a row in list is long pressed 
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(layout,"You have long clicked "+country[position],Snackbar.LENGTH_LONG).show();
                return false;
            }
        });
       // Contains code to filter listview 
        searchtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String tempdata=searchtext.getText().toString();
                ArrayList<String> temp=new ArrayList<String>();
                for(String data:country){
                    if(data.toLowerCase().contains(tempdata.toLowerCase())){
                        temp.add(data);
                    }
                }

                listView.setAdapter(new ArrayAdapter<String>(CountryListView.this,R.layout.listviewrow,temp));;
                // Notify the data is changed 
                ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
