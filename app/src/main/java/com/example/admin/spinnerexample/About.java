package com.example.admin.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class About extends AppCompatActivity {
    private final String htmlText = "<body><h1>Hello Blood Donors</h1><p>This tutorial " +
            "explains how to display " +
            "<strong>HTML </strong>text in android text view.&nbsp;</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView htmlTextView = (TextView)findViewById(R.id.html_text);
        //htmlTextView.sett
    }


}
