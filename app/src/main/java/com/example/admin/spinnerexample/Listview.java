package com.example.admin.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;

public class Listview extends AppCompatActivity {

    String[] mylist_string;
    StringBuffer mybuffer;
    ListView mylistview;
    Dbhelper obj_dbhelper;
    private SimpleAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        Bundle b=getIntent().getExtras();
        String state=b.getString("list_state");
        String bloodgroup=b.getString("list_bloodgroup");
        String district=b.getString("list_district");
        String city=b.getString("list_city");
        String area=b.getString("list_area");


        mylistview = (ListView) findViewById(R.id.sList);
        List<objectfile> donorlist = obj_dbhelper.getData(bloodgroup,state,district,city,area);
        for (objectfile  obj_objectfile: donorlist) {
            mybuffer.append(obj_objectfile.getDonor_name() + " ");
            Toast.makeText(Listview.this,"donor name", Toast.LENGTH_SHORT).show();
        }
        mylist_string = mybuffer.toString().split(" ");

        mylistview = (ListView) findViewById(R.id.sList);

        List<objectfile> contactlist = obj_dbhelper.getData(bloodgroup,state,district,city,area);
        for (objectfile  obj_objectfile: contactlist) {
            mybuffer.append(obj_objectfile.getContact_number() + " ");
           // Toast.makeText(ListView.this, "contact", Toast.LENGTH_SHORT).show();
        }
        mylist_string = mybuffer.toString().split(" ");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Listview.this,android.R.layout.simple_list_item_1,mylist_string);
        mylistview.setAdapter(adapter);
    }

}
