package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class experiment_4_2_3 extends AppCompatActivity {
    public int current = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_4_2_3);
        ListView listView = (ListView) findViewById(R.id.E4_2_3_listView);
        String[] strings = {"item1", "item2", "item3"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, strings);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                current = position;
            }
        });
        Button confirmBtn=(Button)findViewById(R.id.E4_2_3_confirm);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(experiment_4_2_3.this, com.example.admin.myapplication.experiment_4_2_1.class);
                intent.putExtra("itemNum",current);
                startActivity(intent);
            }
        });

    }
}
