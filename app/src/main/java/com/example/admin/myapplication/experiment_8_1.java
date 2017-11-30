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

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class experiment_8_1 extends AppCompatActivity {

    private Button btn4;
    private TextView txtView1;
    private ProgressBar progressBar;

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
        btn4 = (Button) findViewById(R.id.E8_1_download);
        txtView1 = (TextView) findViewById(R.id.E8_1_textVIew);
        progressBar = (ProgressBar) findViewById(R.id.E8_1_progressBar);
//        progressBar.setVisibility(View.INVISIBLE);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoadPictue();
            }
        });
    }

    private class DownImageTask extends AsyncTask<String, Integer, Bitmap> {
        // 执行预处理
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // 显示进度条
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setMax(100);

        }

        // 后台进程的执行
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();//异步操作
                int total = 0;
                int count = 0;
                int length = conn.getContentLength();
                byte data[] = new byte[length];
                InputStream inputStream = conn.getInputStream();//获得当前得到的数据长度
                ByteArrayOutputStream output=new ByteArrayOutputStream();//申请一个可以用来存储byte数组的输出流
                while ((count = inputStream.read(data)) != -1) {//当文件还没输出完的时候继续运行,每一次循环，data数组从输入
                                                                // 流中得到count个字节,存在0-count－1中
                    total += count;//记录总数
                    if (length > 0) // only if total length is known
                        publishProgress((int) (total * 100 / length));
                    output.write(data,0,count);                  //

                }
                byte buffer[] =output.toByteArray();
                bitmap = BitmapFactory.decodeByteArray(buffer,0,length);//每一次缓存把数据从data里面读取出来，即0－count-1之间的数据
                inputStream.close();
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        // 运行于UI线程，对后台任务的结果做出处理，doInBackground方法执行的结果作为此方法的参数
        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            ImageView imageView = (ImageView) findViewById(R.id.E8_1_imageView);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageBitmap(result);
            progressBar.setVisibility(View.GONE);

        }

        // 运行于UI线程，如果在doInBackground(Params...)中使用了publishProgress(Progress...)，就会触发此方法
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            txtView1.setText("" + values[0] + "%");
            progressBar.setProgress(values[0]);

        }

    }

    void downLoadPictue() {
        DownImageTask asyncTask = new DownImageTask();
        asyncTask.execute("http://cyf-img.bdstatic.com/img_59421a5eaf896_09b00b5634b0cd481d8c65360190fd22.jpg");
    }
}
