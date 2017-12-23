package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class experiment_12 extends AppCompatActivity {
    private ListView queryListView;
    private ArrayAdapter<String> resContainer;
    private EditText idInput;
    private EditText userNameInput;
    private EditText openBankInput;
    private CBankDeal cBankDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_12);
        queryListView = (ListView) findViewById(R.id.E12_queryRes);
        idInput = (EditText) findViewById(R.id.E12_idInput);
        userNameInput = (EditText) findViewById(R.id.E12_userNameInput);
        openBankInput = (EditText) findViewById(R.id.E12_openBankInput);
        cBankDeal = new CBankDeal(experiment_12.this);
        queryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] arr=resContainer.getItem(position).split(" ");
                idInput.setText(arr[0]);
                userNameInput.setText(arr[1]);
                openBankInput.setText(arr[2]);
            }
        });
        Button insert = (Button) findViewById(R.id.E12_insert);
        refresh();
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CBankAccount temp = new CBankAccount();
                temp._id = Integer.parseInt(idInput.getText().toString());
                temp.userName = userNameInput.getText().toString();
                temp.OpenBank = openBankInput.getText().toString();
                cBankDeal.insert(temp);
                refresh();
            }
        });
        Button query= (Button) findViewById(R.id.E12_query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<CBankAccount> list = cBankDeal.query(userNameInput.getText().toString());
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
                resContainer=new ArrayAdapter<String>(experiment_12.this,R.layout.support_simple_spinner_dropdown_item,reslist);
                queryListView.setAdapter(resContainer);
            }
        });
        Button update= (Button) findViewById(R.id.E12_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CBankAccount temp = new CBankAccount();
                temp._id = Integer.parseInt(idInput.getText().toString());
                temp.userName = userNameInput.getText().toString();
                temp.OpenBank = openBankInput.getText().toString();
                if(cBankDeal.update(temp)==0){
                    Toast.makeText(experiment_12.this, "找不到对应用户！", Toast.LENGTH_SHORT).show();
                }
                refresh();
            }
        });
        Button delete= (Button) findViewById(R.id.E12_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CBankAccount temp = new CBankAccount();
                temp._id = Integer.parseInt(idInput.getText().toString());
                temp.userName = userNameInput.getText().toString();
                temp.OpenBank = openBankInput.getText().toString();
                if(cBankDeal.delete(temp)==0){
                    Toast.makeText(experiment_12.this, "找不到对应用户！", Toast.LENGTH_SHORT).show();
                }
                refresh();
            }
        });
    }
    public void refresh(){
        ArrayList<CBankAccount> list = cBankDeal.showAll();
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
        resContainer=new ArrayAdapter<String>(experiment_12.this,R.layout.support_simple_spinner_dropdown_item,reslist);
        queryListView.setAdapter(resContainer);
    }
}
