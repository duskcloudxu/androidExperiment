package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class experiment_2 extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private EditText user;
    private EditText password;
    LinearLayout backGround;
    boolean backGroundCounter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_2);
        user = (EditText) findViewById(R.id.E2_user);
        password=(EditText)findViewById(R.id.E2_password);
        height = (EditText) findViewById(R.id.E2_height);
        weight = (EditText) findViewById(R.id.E2_weight);
        backGround = (LinearLayout) findViewById(R.id.E2_layOut);
        Button cipher = (Button) findViewById(R.id.E2_cipher);
        Button reset = (Button) findViewById(R.id.E2_reset);
        Button change = (Button) findViewById(R.id.E2_test);
        cipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(height.getText().toString().equals(""))return;
                if(weight.getText().toString().equals(""))return;
                double heightValue = Integer.parseInt(height.getText().toString());
                int weightValue = Integer.parseInt(weight.getText().toString());
                heightValue /= 100;
                double result = weightValue / (heightValue * heightValue);
                Log.d("height", String.valueOf(heightValue));
                Log.d("weight", String.valueOf(weightValue));
                Log.d("res", String.valueOf(result));

                if (result < 19) {
                    Toast.makeText(experiment_2.this, "体重偏低", Toast.LENGTH_SHORT).show();
                } else if (result < 25) {
                    Toast.makeText(experiment_2.this, "健康体重", Toast.LENGTH_SHORT).show();
                } else if (result < 30) {
                    Toast.makeText(experiment_2.this, "体重偏重", Toast.LENGTH_SHORT).show();
                } else if (result < 39) {
                    Toast.makeText(experiment_2.this, "体重超重", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(experiment_2.this, "肥宅为什么要活在这个世界上呢", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                height.setText("");
                height.clearFocus();
                weight.setText("");
                weight.clearFocus();
                password.setText("");
                password.clearFocus();
                user.setText("");

            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backGroundCounter) {
                    backGround.setBackgroundResource(R.mipmap.a);
                    backGroundCounter=!backGroundCounter;
                }
                else
                {
                    backGround.setBackgroundResource(R.mipmap.b);
                    backGroundCounter=!backGroundCounter;
                }
            }
        });
    }
}

