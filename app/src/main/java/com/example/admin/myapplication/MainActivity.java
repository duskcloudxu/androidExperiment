package com.example.admin.myapplication;

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
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.add_item)
            Toast.makeText(MainActivity.this,"you clicked Add",Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(MainActivity.this,"you clicked Del",Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1=(Button) findViewById(R.id.button);//findViewById返回的是view对象，
                                                       // 即在layout里出现过的对象,需要把它转型成为button对象
                                                       //详见向下转型
        btn1.setOnClickListener(new View.OnClickListener(){  // 这个是写在setOnClickListener底下的类
            @Override
            public void onClick(View V)
            {
                Toast.makeText(MainActivity.this, getResources().getResourceName(V.getId()), Toast.LENGTH_SHORT).show();
            }
        });                     //此为view提供的方法




    }
}
