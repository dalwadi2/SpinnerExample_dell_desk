package com.example.admin.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class Datepicker extends AppCompatActivity  {
    Button btn1_java;
    TextView tv1_java;
    DatePicker datePicker1_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        btn1_java = (Button) findViewById(R.id.btn1);
        tv1_java = (TextView) findViewById(R.id.tv1);
        datePicker1_java = (DatePicker) findViewById(R.id.datePicker1);
        tv1_java.setText(getCurrentDate());

        btn1_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1_java.setText(getCurrentDate());
            }
        });
    }
    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();
        builder.append("Current Date: ");
        builder.append((datePicker1_java.getMonth() + 1)+"/");//month is 0 based
        builder.append(datePicker1_java.getDayOfMonth()+"/");
        builder.append(datePicker1_java.getYear());

        return builder.toString();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datepicker, menu);
        return true;
    }

}



