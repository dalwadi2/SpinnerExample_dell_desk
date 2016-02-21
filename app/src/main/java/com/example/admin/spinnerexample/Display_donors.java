package com.example.admin.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Display_donors extends AppCompatActivity {

    EditText java_display_name;
    EditText java_display_contact;
    Button java_ok;
    Dbhelper obj_dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        obj_dbhelper=new Dbhelper(this);
        java_display_contact=(EditText)findViewById(R.id.display_contact);
        java_display_name=(EditText)findViewById(R.id.display_name);
        java_ok=(Button)findViewById(R.id.button_display);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_donors);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        java_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String s=obj_dbhelper.getAllData();



            }
        });
    }

}
