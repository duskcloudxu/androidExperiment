package com.example.admin.myapplication;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class experiment_4_1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_4_1);
        Log.d("E4test", "onCreate: ");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("E4test", "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("E4test", "onRestart: ");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("E4test", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("E4test", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("E4test", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("E4test", "onDestroy: ");
    }
}
