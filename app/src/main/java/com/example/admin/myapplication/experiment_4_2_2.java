package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class experiment_4_2_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_4_2_2);
        TextView user=(TextView)findViewById(R.id.E4_2_2_user);
        TextView password=(TextView)findViewById(R.id.E4_2_2_password);
        Intent intent=getIntent();
        user.setText(intent.getStringExtra("user"));
        password.setText(intent.getStringExtra("password"));

    }
}
