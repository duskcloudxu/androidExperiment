package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.io.InputStream;

public class experiment_11_3 extends AppCompatActivity {

    private AutoCompleteTextView ATV;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_11_3);
        ATV=(AutoCompleteTextView)findViewById(R.id.E11_3_autoCptTvw);
        btn=(Button)findViewById(R.id.E11_3_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instream：https://stackoverflow.com/questions/5771366/reading-a-simple-text-file
                //json转换：https://stackoverflow.com/questions/18192891/conversion-from-string-to-json-object-android
            }
        });
    }
}
