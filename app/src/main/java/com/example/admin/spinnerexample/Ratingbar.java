package com.example.admin.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Ratingbar extends ActionBarActivity {

    private RatingBar ratingBar;
    private TextView txtRatingValue;
    private Button btnSubmit;
    EditText editText1;
    Dbhelper e;
    String s,s1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);

        addListenerOnRatingBar();
        addListenerOnButton();

        editText1=(EditText)findViewById(R.id.editText);

        e=new Dbhelper(this);

    }

    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                s= String.valueOf(rating);
                txtRatingValue.setText(s);



            }
        });
    }

    public void addListenerOnButton() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //if click on me, then display the current rating value.
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               /* Toast.makeText(Ratingbar.this,
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();*/

                s= String.valueOf(ratingBar.getRating());
                s1=editText1.getText().toString();
                e.insertfeedback(s,s1);

                Toast.makeText(Ratingbar.this, "Thanks for your feedback", Toast.LENGTH_LONG).show();
            }

        });

    }
}