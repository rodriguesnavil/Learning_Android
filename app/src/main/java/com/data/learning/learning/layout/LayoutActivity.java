package com.data.learning.learning.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.data.learning.learning.R;

public class LayoutActivity extends AppCompatActivity {

    EditText username;
    Button pop,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity);
        setTitle("Layout Activity");
        username= (EditText) findViewById(R.id.layoutuser);
        pop= (Button) findViewById(R.id.createtost);
        clear=(Button)findViewById(R.id.clear);

    }

    public void performAction(View view){

        switch(view.getId()){

            case R.id.createtost:   Toast.makeText(this, ""+username.getText(), Toast.LENGTH_SHORT).show();
                                    break;

            case R.id.clear: username.setText("");
                            break;

        }
    }


}
