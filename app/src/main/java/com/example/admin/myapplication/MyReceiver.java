package com.example.admin.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), "mAction"))
            Toast.makeText(context, intent.getAction() + intent.getStringExtra("content"), Toast.LENGTH_SHORT).show();
        else
            Log.d(intent.getAction(), "onReceive: "+intent.getAction());
    }
}
