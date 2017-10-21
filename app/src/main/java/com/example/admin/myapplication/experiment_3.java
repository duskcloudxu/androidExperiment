package com.example.admin.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class experiment_3 extends AppCompatActivity {
    private String[] data = {"Item1", "Item2", "Item3", "Item4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_3);
        ListView listView = (ListView) findViewById(R.id.E3_listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.sample_message_right, data);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("test", "onItemSelected: test");
                Toast.makeText(experiment_3.this, "你选中了" + parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });
        Button sipAlt = (Button) findViewById(R.id.E3_simpleAlert);
        Button cplAlt = (Button) findViewById(R.id.E3_complicatedAlert);
        sipAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(experiment_3.this);
                dlg.setMessage("Good night").setNegativeButton("取消", null)
                        .setPositiveButton("确定", null)
                        .setNeutralButton("帮助", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(experiment_3.this, "I need help", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();


            }
        });


    }
}
