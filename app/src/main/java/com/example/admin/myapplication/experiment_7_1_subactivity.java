package com.example.admin.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class experiment_7_1_subactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_7_1_subactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.E7_1_sub_toolBar);
        toolbar.setTitle("第二个页面大标题");
        toolbar.setSubtitle("第二个页面小标题");
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
