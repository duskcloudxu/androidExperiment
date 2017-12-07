package com.example.admin.myapplication;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class experiment_10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_10);
        final EditText mEditText=(EditText)findViewById(R.id.E10_editText);
        Button mButton=(Button)findViewById(R.id.E10_sendBR);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mBroadcast=new Intent();
                mBroadcast.setAction("mAction");
                mBroadcast.putExtra("content",mEditText.getText().toString());
                sendBroadcast(mBroadcast);
            }
        });
        BroadcastReceiver mBR=new MyReceiver();
        IntentFilter mIntentFilter=new IntentFilter();
        mIntentFilter.addAction("mAction");
        mIntentFilter.addAction(Intent.ACTION_TIME_CHANGED);
        mIntentFilter.addAction(Intent.ACTION_DATE_CHANGED);
        mIntentFilter.addAction(Intent.ACTION_MEDIA_EJECT);
        this.registerReceiver(mBR,mIntentFilter);

    }
}
