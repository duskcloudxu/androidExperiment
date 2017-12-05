package com.example.admin.myapplication;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_item)
            Toast.makeText(MainActivity.this, "you clicked Add", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(MainActivity.this, "you clicked Del", Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();//隐藏默认顶栏
        Button experi_1 = (Button) findViewById(R.id.experi_1);//findViewById返回的是view对象，
        // 即在layout里出现过的对象,需要把它转型成为button对象
        //详见向下转型


        experi_1.setOnClickListener(new View.OnClickListener() {  // 这个是写在setOnClickListener底下的类
            @Override
            public void onClick(View V) {
                Intent experiment_1 = new Intent("android.intent.action.CALL");
                experiment_1.addCategory("android.intent.category.DEFAULT");
                startActivity(experiment_1);
            }
        });                     //此为view提供的方法
        Button experi_2 = (Button) findViewById(R.id.experi_2);

        experi_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_2 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_2.class);
                startActivity(experiment_2);
            }

        });
        Button experi_2_2 = (Button) findViewById(R.id.experi_2_2);

        experi_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_2_2 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_2_2.class);
                startActivity(experiment_2_2);
            }

        });
        Button experi_3 = (Button) findViewById(R.id.experi_3);

        experi_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_3 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_3.class);
                startActivity(experiment_3);
            }

        });
        Button experi_4_1 = (Button) findViewById(R.id.experi_4_1);
        experi_4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_4_1 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_4_1.class);
                startActivity(experiment_4_1);
            }

        });
        Button experi_4_2_1 = (Button) findViewById(R.id.experi_4_2_1);
        experi_4_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_4_2_1 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_4_2_1.class);
                startActivity(experiment_4_2_1);
            }

        });
        Button experi_5 = (Button) findViewById(R.id.experi_5);
        experi_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_5 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_5.class);
                startActivity(experiment_5);
            }

        });
        Button experi_6 = (Button) findViewById(R.id.experi_6);
        experi_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_6 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_6.class);
                startActivity(experiment_6);
            }

        });
        Button experi_7_1 = (Button) findViewById(R.id.experi_7_1);
        experi_7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_7_1 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_7_1.class);
                startActivity(experiment_7_1);
            }

        });
        Button experi_7_2 = (Button) findViewById(R.id.experi_7_2);
        experi_7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_7_2 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_7_2.class);
                startActivity(experiment_7_2);
            }

        });
        Button experi_7_3_1 = (Button) findViewById(R.id.experi_7_3_1);
        experi_7_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_7_3_1 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_7_3_1.class);
                startActivity(experiment_7_3_1);
            }

        });

        Button experi_7_3_2 = (Button) findViewById(R.id.experi_7_3_2);
        experi_7_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_7_3_2 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_7_3_2.class);
                startActivity(experiment_7_3_2);
            }

        });
        Button experi_8_1 = (Button) findViewById(R.id.experi_8_1);
        experi_8_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment_8_1 = new Intent(MainActivity.this, com.example.admin.myapplication.experiment_8_1.class);
                startActivity(experiment_8_1);
            }

        });
        Button weChatSimulater = (Button) findViewById(R.id.weChat_simulate);
        weChatSimulater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WeChatSimulation = new Intent(MainActivity.this, com.example.admin.myapplication.WeChatSimulation.class);
                startActivity(WeChatSimulation);
            }
        });
    }
}
