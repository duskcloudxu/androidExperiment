package com.example.admin.myapplication;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class experiment_8_1 extends AppCompatActivity {

    private Button btn4;
    private TextView txtView1;
    private ProgressBar progressBar;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_8_1);
        Button single = (Button) findViewById(R.id.E8_1_singlePro);
        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10000; i++) {
                    for (int j = 0; j < 10000; j++) {
                        for (int k = 0; k < 10; k++) {
                            int b = i + j + k;
                        }
                    }
                }
            }
        });
        Button multi = (Button) findViewById(R.id.E8_1_multiPro);
        final Handler h = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0)
                    Toast.makeText(experiment_8_1.this, (String) msg.obj, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(experiment_8_1.this, "fail", Toast.LENGTH_SHORT).show();
            }
        };
        final Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    int b = 0;
                    String s = "NULL";
                    for (int i = 0; i < 10000; i++) {
                        for (int j = 0; j < 100; j++) {
                            for (int k = 0; k < 1; k++) {
                                if (this.isInterrupted()) throw new InterruptedException("boom");
                                b++;
                                s = "final";
                            }
                        }
                    }
                    Message message = Message.obtain(h);
                    message.what = 0;
                    message.arg1 = 1;
                    message.arg2 = 3;
                    message.obj = s;
                    message.sendToTarget(); // 完成发送消息的动作
                } catch (InterruptedException consumed) {
                    h.sendEmptyMessage(1);
                    return;
                }

            }
        };
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
            }
        });


        final Handler notice = new Handler() {
            @Override
            @TargetApi(25)
            public void handleMessage(Message msg) {
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.E8_1_progressBar);
                progressBar.setProgress(progressBar.getProgress() + msg.arg1, true);
                Toast.makeText(experiment_8_1.this, "你收到了" + (String) msg.obj + "的消息" + msg.arg1, Toast.LENGTH_SHORT).show();
                super.handleMessage(msg);
            }
        };
        final Button btn1 = (Button) findViewById(R.id.E8_1_progressBtn1);
        final progress pro1 = new progress(notice, btn1.getText().toString(), 3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro1.start();
            }
        });
        final Button btn2 = (Button) findViewById(R.id.E8_1_progressBtn2);
        final progress pro2 = new progress(notice, btn2.getText().toString(), 5);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro2.start();
            }
        });
        final Button btn3 = (Button) findViewById(R.id.E8_1_progressBtn3);
        final progress pro3 = new progress(notice, btn3.getText().toString(), 7);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro3.start();
            }
        });
        final Button terminate = (Button) findViewById(R.id.E8_1_terminate);
        terminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.interrupt();
                pro1.interrupt();
                pro2.interrupt();
                pro3.interrupt();
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn4 = (Button) findViewById(R.id.E8_1_download);
        txtView1 = (TextView) findViewById(R.id.E8_1_textVIew);
        progressBar = (ProgressBar) findViewById(R.id.E8_1_progressBar);
        progressBar.setVisibility(View.INVISIBLE);
    }

}
