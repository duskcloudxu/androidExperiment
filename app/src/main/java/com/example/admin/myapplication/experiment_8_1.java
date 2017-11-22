package com.example.admin.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class experiment_8_1 extends AppCompatActivity {

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
                        for (int j = 0; j < 1000; j++) {
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
        final Button terminate = (Button) findViewById(R.id.E8_1_terminate);
        terminate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.interrupt();
            }
        });
    }
}
