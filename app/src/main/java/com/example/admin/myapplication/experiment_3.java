package com.example.admin.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class experiment_3 extends AppCompatActivity {
    private String[] data = {"Item1","Item2","Item3","Item4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_3);
        ListView listView = (ListView) findViewById(R.id.E3_listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.sample_message_right, data);
        listView.setAdapter(arrayAdapter);


    }
}
