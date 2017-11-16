package com.example.admin.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class experiment_7_3_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_7_3_2);
        final String[]strings={"实时信息","提醒通知","活动路线","相关设置"};
        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,strings);
        ListView listView=(ListView) findViewById(R.id.E7_3_2_listview);
        listView.setAdapter(arrayAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(experiment_7_3_2.this, "you clicked "+ strings[position], Toast.LENGTH_SHORT).show();
                DrawerLayout draw=(DrawerLayout)findViewById(R.id.drawer_layout);
                draw.closeDrawer(GravityCompat.START);
            }
        });
    }
}
