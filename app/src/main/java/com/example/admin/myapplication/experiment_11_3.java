package com.example.admin.myapplication;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.jar.JarException;

public class experiment_11_3 extends AppCompatActivity {

    private AutoCompleteTextView ATV;
    private Button btn;
    private ArrayList<String> userNameList;
    private JSONArray data;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_11_3);
        ATV = (AutoCompleteTextView) findViewById(R.id.E11_3_autoCptTvw);
        btn = (Button) findViewById(R.id.E11_3_login);
        userNameList = new ArrayList<String>();
        context = experiment_11_3.this;
        File file = new File("data.json");
        if (dataRefresh()) {
            dataInit();
        }
        dataRefresh();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = ATV.getText().toString();
                try {
                    JSONObject temp = new JSONObject();
                    temp.put("name", newName);
                    data.put(temp);
                    JSONObject res = new JSONObject();
                    res.put("data", data);
                    Toast.makeText(context, res.toString(), Toast.LENGTH_SHORT).show();
                    try {
                        FileOutputStream fileOutputStream = context.openFileOutput("data.json", MODE_PRIVATE);//使用文件路径
                        fileOutputStream.write(res.toString().getBytes());
                        fileOutputStream.close();
                    } catch (IOException e) {
                        Log.e("Exception", "File write failed: " + e.toString());
                    }
                    dataRefresh();
                } catch (JSONException e) {
                    e.getStackTrace();
                }
            }
        });
    }

    private void dataInit() {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("data.json", MODE_PRIVATE);//使用文件路径
            String init = "{\n" +
                    "  \"data\": [\n" +
                    "    {\n" +
                    "      \"name\": \"test\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";
            fileOutputStream.write(init.getBytes());
            fileOutputStream.close();
            Toast.makeText(context, "data initiated!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private boolean dataRefresh() {
        try {
            InputStream inputStream = openFileInput("data.json");//默认使用文件路径
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String buffer;
            StringBuilder builder = new StringBuilder();
            try {
                while ((buffer = bufferedReader.readLine()) != null) {
                    builder.append(buffer);
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
            try {
                JSONObject temp = new JSONObject(builder.toString());
                data = new JSONArray(temp.getString("data"));
                for (int i = 0; i < data.length(); i++) {
                    JSONObject current = data.getJSONObject(i);
                    userNameList.add(current.getString("name"));
                }
                ArrayAdapter<String> arradpt = new ArrayAdapter<String>(experiment_11_3.this, R.layout.support_simple_spinner_dropdown_item, userNameList);
                ATV.setAdapter(arradpt);
            } catch (JSONException e) {
                e.getStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.getStackTrace();
            return true;
        }
        return false;
    }
}
