package com.example.admin.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class experiment_11 extends AppCompatActivity {
    private SharedPreferences prefer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_11);
        prefer = getSharedPreferences("preference", 0);
        EditText user = (EditText) findViewById(R.id.E11_username);
        EditText password = (EditText) findViewById(R.id.E11_password);
        ToggleButton isRem = (ToggleButton) findViewById(R.id.E11_toggleBtn);
        if (prefer.getBoolean("isRemember", false)) {
            user.setText(prefer.getString("username", "NULL"));
            password.setText(prefer.getString("password", "NULL"));
            isRem.setChecked(true);
        }
        else{
            prefer.edit()
                    .putString("username","")
                    .putString("password", "")
                    .apply();
        }
        isRem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    prefer.edit()
                            .putBoolean("isRemember", true)
                            .apply();
                } else {
                    prefer.edit()
                            .putBoolean("isRemember", false)
                            .apply();
                }
            }
        });
        Button login = (Button) findViewById(R.id.E11_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prefer.getBoolean("isRemember", false))
                    prefer.edit()
                            .putString("username", (((EditText) findViewById(R.id.E11_username))).getText().toString())
                            .putString("password", (((EditText) findViewById(R.id.E11_password))).getText().toString())
                            .apply();
            }
        });

    }
}
