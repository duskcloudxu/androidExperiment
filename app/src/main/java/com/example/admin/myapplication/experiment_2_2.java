package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class experiment_2_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_2_2);
        Spinner province = (Spinner) findViewById(R.id.E2_provinceSpin);
        Spinner city = (Spinner) findViewById(R.id.E2_citySpin);
        Spinner subdivide = (Spinner) findViewById(R.id.E2_subdivideSpin);
        String[] provinceListData = getResources().getStringArray(R.array.E2_provinceList);
        ArrayAdapter provinceList = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, provinceListData);
        province.setAdapter(provinceList);
        String[] cityListData = getResources().getStringArray(R.array.E2_cityInZ);
        ArrayAdapter cityList = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cityListData);
        city.setAdapter(cityList);
        String[] subdivideListData = getResources().getStringArray(R.array.E2_hangZhou);
        ArrayAdapter subdivideList = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, subdivideListData);
        subdivide.setAdapter(subdivideList);
        province.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner city = (Spinner) findViewById(R.id.E2_citySpin);
                Spinner subdivide = (Spinner) findViewById(R.id.E2_subdivideSpin);
                switch (position) {
                    case 0: {
                        Toast.makeText(experiment_2_2.this, "0", Toast.LENGTH_SHORT).show();
                        String[] cityListData = getResources().getStringArray(R.array.E2_cityInZ);
                        ArrayAdapter cityList = new ArrayAdapter<String>(experiment_2_2.this, R.layout.support_simple_spinner_dropdown_item, cityListData);
                        city.setAdapter(cityList);
                        String[] subdivideListData = getResources().getStringArray(R.array.E2_hangZhou);
                        ArrayAdapter subdivideList = new ArrayAdapter<String>(experiment_2_2.this, R.layout.support_simple_spinner_dropdown_item, subdivideListData);
                        subdivide.setAdapter(subdivideList);
                        break;
                    }
                    case 1: {
                        String[] cityListData = getResources().getStringArray(R.array.E2_cityInJ);
                        ArrayAdapter cityList = new ArrayAdapter<String>(experiment_2_2.this, R.layout.support_simple_spinner_dropdown_item, cityListData);
                        city.setAdapter(cityList);
                        String[] subdivideListData = getResources().getStringArray(R.array.E2_nanJing);
                        ArrayAdapter subdivideList = new ArrayAdapter<String>(experiment_2_2.this, R.layout.support_simple_spinner_dropdown_item, subdivideListData);
                        subdivide.setAdapter(subdivideList);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
