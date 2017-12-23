package com.example.admin.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;

public class experiment_12_1 extends AppCompatActivity {
    private ListView queryListView;
    private ArrayAdapter<String> resContainer;
    private EditText idInput;
    private EditText userNameInput;
    private EditText openBankInput;
    private String tableName = "userList";
    private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_12_1);
        queryListView = (ListView) findViewById(R.id.E12_1_queryRes);
        idInput = (EditText) findViewById(R.id.E12_1_idInput);
        userNameInput = (EditText) findViewById(R.id.E12_1_userNameInput);
        openBankInput = (EditText) findViewById(R.id.E12_1_openBankInput);
        uri=Uri.parse("content://com.example.admin.myapplication.myCntProv");
        queryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] arr=resContainer.getItem(position).split(" ");
                idInput.setText(arr[0]);
                userNameInput.setText(arr[1]);
                openBankInput.setText(arr[2]);
            }
        });
        Button insert = (Button) findViewById(R.id.E12_1_insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CBankAccount temp = new CBankAccount();
                temp._id = Integer.parseInt(idInput.getText().toString());
                temp.userName = userNameInput.getText().toString();
                temp.OpenBank = openBankInput.getText().toString();
                ContentValues cv=new ContentValues();
                cv.put("_id",temp._id);
                cv.put("userName",temp.userName);
                cv.put("openBank",temp.OpenBank);
                getContentResolver().insert(uri,cv);
            }
        });
        Button query= (Button) findViewById(R.id.E12_1_query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = getContentResolver().query(uri,new String[]{}, "userName = ?", new String[]{userNameInput.getText().toString()}, null);
                ArrayList<CBankAccount> list = new ArrayList<>();
                while (c.moveToNext()) {
                    CBankAccount temp = new CBankAccount();
                    temp._id = c.getInt(c.getColumnIndex("_id"));
                    temp.userName = c.getString(c.getColumnIndex("userName"));
                    temp.OpenBank = c.getString(c.getColumnIndex("openBank"));
                    list.add(temp);
                }
                ArrayList<String> reslist = new ArrayList<String>();
                for (int i = 0; i < list.size(); i++) {
                    String temp = "";
                    temp += list.get(i)._id;
                    temp+= " ";
                    temp += list.get(i).userName;
                    temp+= " ";
                    temp += list.get(i).OpenBank;
                    reslist.add(temp);
                }
                resContainer=new ArrayAdapter<String>(experiment_12_1.this,R.layout.support_simple_spinner_dropdown_item,reslist);
                queryListView.setAdapter(resContainer);
            }
        });
        Button update= (Button) findViewById(R.id.E12_1_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CBankAccount temp = new CBankAccount();
                temp._id = Integer.parseInt(idInput.getText().toString());
                temp.userName = userNameInput.getText().toString();
                temp.OpenBank = openBankInput.getText().toString();
                ContentValues cv=new ContentValues();
                cv.put("_id",temp._id);
                cv.put("userName",temp.userName);
                cv.put("openBank",temp.OpenBank);
                if( getContentResolver().update(uri,cv,"test",new String[]{"test"})==0){
                    Toast.makeText(experiment_12_1.this, "找不到对应用户！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button delete= (Button) findViewById(R.id.E12_1_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CBankAccount temp = new CBankAccount();
                temp._id = Integer.parseInt(idInput.getText().toString());
                temp.userName = userNameInput.getText().toString();
                temp.OpenBank = openBankInput.getText().toString();
                ContentValues cv=new ContentValues();
                cv.put("_id",temp._id);
                cv.put("userName",temp.userName);
                cv.put("openBank",temp.OpenBank);
                if(getContentResolver().delete(uri,"test",new String[]{cv.get("userName").toString()})==0){
                    Toast.makeText(experiment_12_1.this, "找不到对应用户！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
