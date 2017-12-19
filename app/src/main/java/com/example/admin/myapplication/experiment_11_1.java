package com.example.admin.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class experiment_11_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_11_1);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        PreferenceFragment prefFragment = new preferenceFrag();
        transaction.add(R.id.E11_1_container, prefFragment);
        transaction.commit();


    }
}
