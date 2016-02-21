package com.example.admin.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Search_donor extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {


    String[] bloodgroup = { "select bloodgroup","A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    String[] states = { "select state","Gujarat", "Rajasthan", "Maharashtra"};
    String[] district = { "select district","Ahmedabad", "udaipur", "Mumbai"};
    String[] cities = { "select city","Ahmedabad", "udaipur", "Mumbai"};
    String[] areas = {"select area", "ankur","jaymangal", "mulund"};
    Spinner bg_spinner;
    Spinner state_spinner;
    Spinner District_spinner;
    Spinner city_spinner;
    Spinner area_spinner;
    Dbhelper obj_dbhelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donor);


    bg_spinner = (Spinner) findViewById(R.id.spinner_bloodgroup);
    state_spinner = (Spinner) findViewById(R.id.spinner_state);
    District_spinner = (Spinner) findViewById(R.id.spinner_district);
    city_spinner = (Spinner) findViewById(R.id.spinner_city);
        area_spinner = (Spinner) findViewById(R.id.spinner_area);


    bg_spinner.setOnItemSelectedListener(this);
    state_spinner.setOnItemSelectedListener(this);
    District_spinner.setOnItemSelectedListener(this);
    city_spinner.setOnItemSelectedListener(this);
        area_spinner.setOnItemSelectedListener(this);


    ArrayAdapter bg_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, bloodgroup);
    ArrayAdapter state_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, states);
    ArrayAdapter district_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, district);
    ArrayAdapter city_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cities);
        ArrayAdapter area_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, areas);


    bg_spinner.setAdapter(bg_adapter);
    state_spinner.setAdapter(state_adapter);
    District_spinner.setAdapter(district_adapter);
    city_spinner.setAdapter(city_adapter);
        area_spinner.setAdapter(area_adapter);

        Button btn_java=(Button)findViewById(R.id.search_btn);
        btn_java.setOnClickListener(this);

        obj_dbhelper=new Dbhelper(this);

    }



    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
       // Toast.makeText(this, bloodgroup[position], Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {

    }

    public void onClick(View v)
    {

        final String state=state_spinner.getSelectedItem().toString();
        final String district=District_spinner.getSelectedItem().toString();
        final String city=city_spinner.getSelectedItem().toString();
        final String area=area_spinner.getSelectedItem().toString();
        final String bloodgroup=bg_spinner.getSelectedItem().toString();




        if(bloodgroup=="select bloodgroup")
        {

            //java_contact_no.setHint("enter contact_no");
            Toast.makeText(this, "enter all values", Toast.LENGTH_SHORT).show();
            return;
        }
        if(state=="select district")
        {
            //java_contact_no.setHint("enter contact_no");
            Toast.makeText(this, "enter all values", Toast.LENGTH_SHORT).show();
            return;
        }
        if(district=="select district")
        {
            //java_contact_no.setHint("enter contact_no");
            Toast.makeText(this, "enter all values", Toast.LENGTH_SHORT).show();
            return;
        }
        if(city=="select city")
        {
            //java_contact_no.setHint("enter contact_no");
            Toast.makeText(this, "enter all values", Toast.LENGTH_SHORT).show();
            return;
        }
        if(area=="select area")
        {
            //java_contact_no.setHint("enter contact_no");
            Toast.makeText(this, "enter all values", Toast.LENGTH_SHORT).show();
            return;
        }

        Button mButton= (Button) findViewById(R.id.search_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Log.d("BAPS", String.valueOf(mBapsdbHelper.flag));
                List<objectfile> mStudentList = obj_dbhelper.getData(bloodgroup, state, city, district, area);
                for(objectfile obj_objectfile :  mStudentList){
                    Toast.makeText(Search_donor.this,obj_objectfile.getDonor_name() + " :"+ obj_objectfile.getContact_number(),Toast.LENGTH_LONG).show();
                   // Toast.makeText(Search_donor.this,"obj_objectfile.get.getDonor_name()",Toast.LENGTH_LONG).show();
                    //Log.e(TAG,"ID : "+mStudent.getId() + "   Name : "+mStudent.getName());
                }
            }
        });
    }
  /*bundle      Intent to_list_deatils=new Intent(Search_donor.this,Listview.class);
        Bundle bundle_obj =new Bundle();
        bundle_obj.putString("list_state","state");
        bundle_obj.putString("list_distict","district");
        bundle_obj.putString("list_city","city");
        bundle_obj.putString("list_area","area");
        bundle_obj.putString("list_bloodgroup", "bloodgroup");
        to_list_deatils.putExtras(bundle_obj);
        startActivity(to_list_deatils); */


        //obj_dbhelper = new Dbhelper(Search_donor.this);
       // obj_dbhelper.getData(bloodgroup, state, district, city, area);

       // Toast.makeText(this,"searching",Toast.LENGTH_LONG).show();


        /* mylistview = (ListView) findViewById(R.id.sList);
        List<objectfile> donorlist = obj_dbhelper.getData(bloodgroup,state,district,city,area);
        for (objectfile  obj_objectfile: donorlist) {
            mybuffer.append(obj_objectfile.getDonor_name() + " ");
             Toast.makeText(Search_donor.this,"donor name",Toast.LENGTH_SHORT).show();
        }
        mylist_string = mybuffer.toString().split(" ");

        mylistview = (ListView) findViewById(R.id.sList);
        List<objectfile> contactlist = obj_dbhelper.getData(bloodgroup,state,district,city,area);
        for (objectfile  obj_objectfile: contactlist) {
            mybuffer.append(obj_objectfile.getContact_number() + " ");
            Toast.makeText(Search_donor.this,"contact",Toast.LENGTH_SHORT).show();
        }
        mylist_string = mybuffer.toString().split(" "); */


       // System.out.print(donor);
       // Toast.makeText(this,donor ,Toast.LENGTH_LONG).show();

       // String contact = dbhelper.getData().get(0).getContact_number();
       // System.out.print(contact);
       // Toast.makeText(this,contact ,Toast.LENGTH_LONG).show();


    }



