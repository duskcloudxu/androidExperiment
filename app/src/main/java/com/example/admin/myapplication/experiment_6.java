package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class experiment_6 extends AppCompatActivity {
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_6);
        mIntent = new Intent(experiment_6.this, updateService.class);
        Button updateStartBtn = (Button) findViewById(R.id.E6_startUpdateServiceBtn);
        updateStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("btn", "onClick: test");
                startService(mIntent);
            }
        });
        Button updateCloseBtn = (Button) findViewById(R.id.E6_closeUpdateServiceBtn);
        updateCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(mIntent);
            }
        });
    }
}
