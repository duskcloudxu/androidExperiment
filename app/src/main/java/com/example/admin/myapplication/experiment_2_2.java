package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
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

        RadioButton male = (RadioButton) findViewById(R.id.E2_male);
        RadioButton female = (RadioButton) findViewById(R.id.E2_female);
        RadioButton.OnClickListener myRadioListener = new RadioButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.E2_male:
                        Toast.makeText(experiment_2_2.this, "男", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.E2_female:
                        Toast.makeText(experiment_2_2.this, "女", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        male.setOnClickListener(myRadioListener);
        female.setOnClickListener(myRadioListener);

        CheckBox math = (CheckBox) findViewById(R.id.E2_math);
        CheckBox chinese = (CheckBox) findViewById(R.id.E2_chinese);
        CheckBox english = (CheckBox) findViewById(R.id.E2_english);
        CompoundButton.OnCheckedChangeListener myListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                if (isChecked) {
                    switch (v.getId()) {
                        case R.id.E2_chinese:
                            Toast.makeText(experiment_2_2.this, "chinese", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.E2_math:
                            Toast.makeText(experiment_2_2.this, "math", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.E2_english:
                            Toast.makeText(experiment_2_2.this, "english", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        };

        math.setOnCheckedChangeListener(myListener);
        chinese.setOnCheckedChangeListener(myListener);
        english.setOnCheckedChangeListener(myListener);


    }

}
