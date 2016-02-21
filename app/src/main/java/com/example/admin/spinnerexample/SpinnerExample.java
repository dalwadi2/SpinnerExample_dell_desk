package com.example.admin.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerExample extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {


    String[] bloodgroup = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    String[] states = {"select state","Gujarat", "Rajasthan", "Maharashtra"};
    String[] disticts = {"select district","Ahmedabad", "udaipur", "Mumbai"};
    String[] cities = {"select city","Ahmedabad", "udaipur", "Mumbai"};
    String[] areas = {"select area","naranpura", "jaymangal", "mulund"};
    Spinner spinner_bloodgroup;
    Spinner spinner_state;
    Spinner spinner_distict;
    Spinner spinner_city;
    Spinner spinner_area;
    RadioGroup java_gender;
    EditText java_fullname;
    EditText java_contact_no;
    EditText java_birthdate;
    EditText java_address;
    Dbhelper obj_dbhelper;
    Button ok_buttonjava;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);

        obj_dbhelper=new Dbhelper(this);


        //edit text
         java_fullname=(EditText)findViewById(R.id.xml_fullname);
         java_contact_no=(EditText)findViewById(R.id.xml_contact);
         java_birthdate=(EditText)findViewById(R.id.xml_birthdate);
         java_address=(EditText)findViewById(R.id.xml_address);

        //radiobutton-gender
        java_gender=(RadioGroup)findViewById(R.id.xml_radiogroup_gender);
       // String java_gendervalue=  ((RadioButton)this.findViewById(java_gender.getCheckedRadioButtonId())).getText().toString();




         spinner_bloodgroup = (Spinner) findViewById(R.id.xml_bloodgroup);
        spinner_state = (Spinner) findViewById(R.id.xml_state);
         spinner_distict = (Spinner) findViewById(R.id.xml_district);
         spinner_city = (Spinner) findViewById(R.id.xml_city);
        spinner_area = (Spinner) findViewById(R.id.xml_area);

        ok_buttonjava=(Button)findViewById(R.id.xml_ok_button);
        ok_buttonjava.setOnClickListener(this);



        spinner_bloodgroup.setOnItemSelectedListener(this);
        spinner_state.setOnItemSelectedListener(this);
        spinner_distict.setOnItemSelectedListener(this);
        spinner_city.setOnItemSelectedListener(this);
        spinner_area.setOnItemSelectedListener(this);


        ArrayAdapter adapter_bloodgroup = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, bloodgroup);
        ArrayAdapter adapter_state = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, states);
        ArrayAdapter adapter_district = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, disticts);
        ArrayAdapter adapter_city = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cities);
        ArrayAdapter adapter_area = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, areas);



        spinner_bloodgroup.setAdapter(adapter_bloodgroup);
        spinner_state.setAdapter(adapter_state);
        spinner_distict.setAdapter(adapter_district);
        spinner_city.setAdapter(adapter_city);
        spinner_area.setAdapter(adapter_area);

    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
       /*String text_spinner_gender=spinner_gender.getSelectedItem().toString();
        String text_spinner_state=spinner_state.getSelectedItem().toString();
        String text_spinner_district=spinner_distict.getSelectedItem().toString();
        String text_spinner_city=spinner_city.getSelectedItem().toString();
        String text_spinner_area=spinner_area.getSelectedItem().toString(); */
    }

    public void onNothingSelected(AdapterView<?> arg0) {

    }
    public void onClick(View v)
    {
        //retrive all values
        String fullname= java_fullname.getText().toString();
        String contact_no= java_contact_no.getText().toString();
        String birthdate = java_birthdate.getText().toString();
        String address=java_address.getText().toString();

        String gendervalue=  ((RadioButton)this.findViewById(java_gender.getCheckedRadioButtonId())).getText().toString();

        String state=spinner_state.getSelectedItem().toString();
        String district=spinner_distict.getSelectedItem().toString();
        String city=spinner_city.getSelectedItem().toString();
        String area=spinner_area.getSelectedItem().toString();
        String bloodgroup=spinner_bloodgroup.getSelectedItem().toString();

        obj_dbhelper.insertdata(fullname,contact_no,bloodgroup,gendervalue,birthdate,address,state,district,city,area);

        //values
        if(TextUtils.isEmpty(fullname))
        {
           // java_fullname.setHint("this can't be empty");
            //return;
            toast.makeText(this, "enter all values", toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(contact_no))
        {
            //java_contact_no.setHint("enter contact_no");
            toast.makeText(this, "enter all values", toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(birthdate))
        {
           // java_birthdate.setHint("enter birthdate");
            toast.makeText(this, "enter all values", toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(address))
        {
           // java_address.setHint("enter address");
            toast.makeText(this, "enter all values", toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(gendervalue))
        {
            toast.makeText(this, "enter all values", toast.LENGTH_SHORT).show();
            return;
        }
        if(state=="select state")
        {
            toast.makeText(this,"enter all values",toast.LENGTH_SHORT).show();
            return;
        }
        if(district=="select district")
        {
            toast.makeText(this,"enter all values",toast.LENGTH_SHORT).show();
            return;
        }
        if(city=="select city")
        {
            toast.makeText(this,"enter all values",toast.LENGTH_SHORT).show();
            return;
        }
        if(area=="select area")
        {
            toast.makeText(this,"enter all values",toast.LENGTH_SHORT).show();
            return;
        }
        if(bloodgroup=="select bloodgroup")
        {
            toast.makeText(this,"enter all values",toast.LENGTH_SHORT).show();
            return;
        }
        toast.makeText(this,"you are now registered",Toast.LENGTH_LONG).show();

    }

}
