package com.example.admin.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import java.lang.reflect.Method;

public class experiment_7_1 extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.experiment_7_1_overflowmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onMenuOpened(int featureId, Menu menu)
    {
        if(menu != null){
            if(menu.getClass().getSimpleName().equals("MenuBuilder")){
                try{
                    Method m = menu.getClass().getDeclaredMethod(//向目标实例中申请对应参数的指针，并修改，必须要在try-catch结构中写
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                }
                catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.E7_1_search:{
                Intent intent=new Intent(experiment_7_1.this, experiment_7_1_subactivity.class);
                startActivity(intent);
                break;
            }
            case  R.id.E7_1_button:{
                Toast.makeText(this, "你点到了actionButton", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)actionBar.hide();//隐藏默认顶栏
        setContentView(R.layout.activity_experiment_7_1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.E7_1_toolBar);
        toolbar.setTitle("大标题");
        toolbar.setSubtitle("小标题");
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

    }
}
