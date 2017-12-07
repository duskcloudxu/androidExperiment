package com.example.admin.myapplication;

import android.annotation.TargetApi;
import android.icu.util.TimeUnit;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class networkAccessing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_accessing);
        OkHttpClient mHttpClient=new OkHttpClient().newBuilder().connectTimeout(10, java.util.concurrent.TimeUnit.SECONDS).build();




    }
}
