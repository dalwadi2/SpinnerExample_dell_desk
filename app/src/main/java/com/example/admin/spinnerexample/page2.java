package com.example.admin.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class page2 extends AppCompatActivity implements View.OnClickListener {

    Button java_ok_button;
    EditText java_fullname;
    EditText java_date;
    EditText java_donor;
    EditText java_bloodgroup;
    Dbhelper obj_dbhelper;
   // Dbhelper dbhelper;
    //TextView et_fullname_java,et_contact_java,et_birthdate_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        obj_dbhelper=new Dbhelper(this);


       /* on_button_java =(Button)findViewById(R.id.ok_button);
        on_button_java.setOnClickListener(this);

        et_fullname_java=(TextView)findViewById(R.id.et_fullname);
        et_contact_java=(TextView)findViewById(R.id.et_contact);*/

        java_ok_button=(Button)findViewById(R.id.ok_button);
       java_ok_button.setOnClickListener(this);

        java_fullname=(EditText)findViewById(R.id.xml_fullname);
       // java_fullname.setOnClickListener(this);

        java_date=(EditText)findViewById(R.id.xml_date);
       // java_date.setOnClickListener(this);

        java_donor=(EditText)findViewById(R.id.xml_donor);
        //java_donor.setOnClickListener(this);

        java_bloodgroup=(EditText)findViewById(R.id.xml_bloodgroup);
       // java_bloodgroup.setOnClickListener(this);



        //Dbhelper dbhelper;

    }
    public void onClick(View v)
    {

        String Recipient=java_fullname.getText().toString();
        String donor=java_donor.getText().toString();
        String date=java_date.getText().toString();
        String bloodgroup=java_bloodgroup.getText().toString();


        if(TextUtils.isEmpty(Recipient))
        {
            // java_fullname.setHint("this can't be empty");
            //return;
            Toast.makeText(this, "enter all values", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(donor))
        {
            // java_fullname.setHint("this can't be empty");
            //return;
            Toast.makeText(this, "enter all values", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(date))
        {
            // java_fullname.setHint("this can't be empty");
            //return;
            Toast.makeText(this, "enter all values", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(bloodgroup))
        {
            // java_fullname.setHint("this can't be empty");
            //return;
            Toast.makeText(this, "enter all values", Toast.LENGTH_SHORT).show();
            return;
        }


       // obj_dbhelper.insert_donation_history(fullname,donor,date,bloodgroup);
        obj_dbhelper.insert_donation_history(Recipient,donor,date,bloodgroup);

        Toast.makeText(this,"your donation history has been saved",Toast.LENGTH_LONG).show();



    }



}
