package com.example.admin.spinnerexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Welcome_Blood_Donors extends AppCompatActivity {

    Button java_btn_register;
    Button java_btn_searchdonor;
    Button java_btn_donation_history;
    Button java_btn_share_app;
    Button java_btn_rate_app;
    Button java_btn_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__blood__donors);

        java_btn_register = (Button) findViewById(R.id.btn_register);
        java_btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Toast.makeText(Welcome_Blood_Donors.this,"hello",Toast.LENGTH_LONG).show();
                    Intent to_SpinnerExample = new Intent(Welcome_Blood_Donors.this, SpinnerExample.class);
                    startActivity(to_SpinnerExample);
                } catch (Exception e) {
                    Toast.makeText(Welcome_Blood_Donors.this, " " + e, Toast.LENGTH_LONG).show();
                }
            }
        });

        java_btn_searchdonor = (Button) findViewById(R.id.xml_search_donor);
        java_btn_searchdonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_Search_donor = new Intent(Welcome_Blood_Donors.this, Search_donor.class);
                startActivity(to_Search_donor);


            }
        });

        java_btn_donation_history = (Button) findViewById(R.id.btn_donation_history);
        java_btn_donation_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_donation_history = new Intent(Welcome_Blood_Donors.this, page2.class);
                startActivity(to_donation_history);
            }
        });

        java_btn_share_app = (Button) findViewById(R.id.btn_share_app);
        java_btn_share_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "share");

                v.getContext().startActivity(Intent.createChooser(intent, "Share using"));


            }
        });
       java_btn_rate_app = (Button) findViewById(R.id.btn_rate_app);
        java_btn_rate_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent to_rating_bar = new Intent(Welcome_Blood_Donors.this, Ratingbar.class);
                    startActivity(to_rating_bar);
                } catch (Exception e) {
                    Toast.makeText(Welcome_Blood_Donors.this,""+e, Toast.LENGTH_LONG).show();
                }
            }
        });
       /* java_btn_about=(Button)findViewById(R.id.btn_about);
        java_btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent to_about=new Intent(Welcome_Blood_Donors.this,About.class);
                    startActivity(to_about);
                } catch (Exception e) {
                    Toast.makeText(Welcome_Blood_Donors.this,""+e,Toast.LENGTH_SHORT).show();

































                   }

            }
   }); */



    }

}
