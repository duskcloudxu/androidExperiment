package com.example.admin.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class experiment_7_2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_7_2);
        TabLayout tl = (TabLayout) findViewById(R.id.E7_2_tabLayout);
        tl.setTabMode(TabLayout.MODE_FIXED);
        tl.addTab(tl.newTab().setText("头条").setIcon(R.mipmap.ic_launcher));
        tl.addTab(tl.newTab().setText("娱乐").setIcon(R.mipmap.ic_launcher));
        tl.addTab(tl.newTab().setText("体育").setIcon(R.mipmap.ic_launcher));
        ViewPager vp = (ViewPager) findViewById(R.id.E7_2_viewPager);

        tl.setupWithViewPager(vp);
        fragmentPagesManager fragmentPagesManager= new fragmentPagesManager(getSupportFragmentManager());
        fragmentPagesManager.addFragment(new experiment_7_2_headLine(),"头条");
        fragmentPagesManager.addFragment(new experiment_7_2_recreation(),"娱乐");
        fragmentPagesManager.addFragment(new experiment_7_2_sports(),"体育");
        vp.setAdapter(fragmentPagesManager);


    }

}
