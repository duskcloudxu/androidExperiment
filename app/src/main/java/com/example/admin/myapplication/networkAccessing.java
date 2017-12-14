package com.example.admin.myapplication;

import android.annotation.TargetApi;

import java.util.concurrent.TimeUnit;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class networkAccessing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_accessing);
        downloadAsynctask downloadAsynctask = new downloadAsynctask();
        downloadAsynctask.execute("http://wthrcdn.etouch.cn/weather_mini?city=杭州");
        Button login = (Button) findViewById(R.id.networkAccessing_login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userName = (EditText) findViewById(R.id.networkAccessing_userName);
                EditText password = (EditText) findViewById(R.id.networkAccessing_password);
                String strUsername = userName.getText().toString();
                String strPassword = password.getText().toString();
                OkHttpClient mHttpClient = new OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(10, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .build();
                FormBody formbody = new FormBody.Builder()
                        .add("user_id", strUsername)
                        .add("password", strPassword)
                        .build();
                Request request = new Request.Builder()
                        .url("https://d-star.xyz/android/login.php")
                        .post(formbody)
                        .build();
                Toast.makeText(networkAccessing.this, "test", Toast.LENGTH_SHORT).show();
                mHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Toast.makeText(networkAccessing.this, response.body().string(), Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            }
        });


    }

    private class downloadAsynctask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            OkHttpClient mHttpClient = new OkHttpClient().newBuilder().connectTimeout(10, java.util.concurrent.TimeUnit.SECONDS).build();
            //此处需要注意的是request的构建函数是一个私有函数，不能被外部访问，要去的request对象必须调用该类的builder函数。
            final okhttp3.Request request = new okhttp3.Request.Builder().url(params[0]).build();
            String result;
            try {
                Response response = mHttpClient.newCall(request).execute();
                result = response.body().string();
            } catch (IOException e) {
                return "download failed for:" + e.getMessage();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            networkAccessing_response response = gson.fromJson(s, networkAccessing_response.class);
            if (response.status == 1002) {
                Toast.makeText(networkAccessing.this, "不存在的", Toast.LENGTH_SHORT).show();
                return;
            }
            ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(networkAccessing.this, R.layout.support_simple_spinner_dropdown_item, response.data.getresult());
            ListView listview = (ListView) findViewById(R.id.networkAccessing_listView);
            listview.setAdapter(mAdapter);

        }
    }
}
