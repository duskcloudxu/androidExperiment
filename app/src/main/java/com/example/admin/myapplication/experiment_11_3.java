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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class experiment_11_3 extends AppCompatActivity {

    private AutoCompleteTextView ATV;
    private Button btn;
    private ArrayList<String> userNameList;
    private JSONObject data;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_11_3);
        ATV = (AutoCompleteTextView) findViewById(R.id.E11_3_autoCptTvw);
        btn = (Button) findViewById(R.id.E11_3_login);
        userNameList = new ArrayList<String>();
        context = experiment_11_3.this;
        File file = new File(getCacheDir() + "data.json");
        try {
            InputStream inputStream = new FileInputStream(file);
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
                data = new JSONObject(builder.toString());
                JSONArray jsonArr = new JSONArray(data.getString("data"));
                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject current = jsonArr.getJSONObject(i);
                    Toast.makeText(experiment_11_3.this, current.getString("name"), Toast.LENGTH_SHORT).show();
                    userNameList.add(current.getString("name"));
                }
                ArrayAdapter<String> arradpt = new ArrayAdapter<String>(experiment_11_3.this, R.layout.support_simple_spinner_dropdown_item, userNameList);
                ATV.setAdapter(arradpt);
            } catch (JSONException e) {
                e.getStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = ATV.getText().toString();
                try {
                    JSONObject temp = new JSONObject();
                    temp.put("name", newName);
                    JSONArray jsonArr = new JSONArray();
                    if (data!=null) {
                        jsonArr= new JSONArray(data.getString("data"));
                    }
                    jsonArr.put(temp);
                    JSONObject res = new JSONObject();
                    res.put("data", jsonArr);
                    Toast.makeText(context, res.toString(), Toast.LENGTH_SHORT).show();
                    try {
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(getCacheDir() + "data.json", Context.MODE_PRIVATE));
                        outputStreamWriter.write(res.toString());
                        outputStreamWriter.close();
                    } catch (IOException e) {
                        Log.e("Exception", "File write failed: " + e.toString());
                    }
                } catch (JSONException e) {
                    e.getStackTrace();
                }
            }
        });
    }
}
