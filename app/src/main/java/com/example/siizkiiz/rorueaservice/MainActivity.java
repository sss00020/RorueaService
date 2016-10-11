package com.example.siizkiiz.rorueaservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerline = (Spinner) findViewById(R.id.spinnerline);
        Spinner spinnernameboat = (Spinner) findViewById(R.id.spinnernameboat);
        Spinner spinnertype = (Spinner) findViewById(R.id.spinnertype);
        final Button btnext = (Button) findViewById(R.id.btnext);


        spinnerline.setOnItemSelectedListener(this);
        List<String> categoriesline = new ArrayList<>();
        categoriesline.add("เรือด่วนธงส้ม(Orange)");
        categoriesline.add("เรือด่วนธงเหลือง(Yellow)");
        categoriesline.add("เรือด่วนธงเขียว(Green)");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoriesline);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerline.setAdapter(dataAdapter);


        spinnerline.setOnItemSelectedListener(this);
        List<String> categoriesname = new ArrayList<>();
        categoriesname.add("174");
        categoriesname.add("175");
        categoriesname.add("176");
        categoriesname.add("177");
        categoriesname.add("178");
        categoriesname.add("179");
        categoriesname.add("180");
        categoriesname.add("181");
        ArrayAdapter<String> dataAdaptername = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoriesname);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnernameboat.setAdapter(dataAdaptername);


        spinnertype.setOnItemSelectedListener(this);
        List<String> categoriestype = new ArrayList<>();
        categoriestype.add("นนทบุรี(Nonthaburi)");
        categoriestype.add("วัดราชสิงขร(Wat Rajsingkorn)");
        ArrayAdapter<String> dataAdaptertype = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoriestype);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertype.setAdapter(dataAdaptertype);

        btnext.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent mapuserIntent = new Intent(MainActivity.this,GpsService.class);
                MainActivity.this.startActivity(mapuserIntent);
            }
        });

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
