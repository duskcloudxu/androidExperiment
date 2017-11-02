package com.example.admin.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class experiment_4_2_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_4_2_1);
        Button makeCall = (Button) findViewById(R.id.E4_2_1_makeCall);
        makeCall.setOnClickListener(new View.OnClickListener() {
            TextView phoneNum = (TextView) findViewById(R.id.E4_2_1_phoneNum);
            @Override
            public void onClick(View v) {
                String phoneNumString = phoneNum.getText().toString();
                phoneNumString = "tel:" + phoneNumString;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumString));
                startActivity(intent);
            }
        });
        Button login=(Button)findViewById(R.id.E4_2_1_Login);
        login.setOnClickListener(new View.OnClickListener() {
            TextView user=(TextView)findViewById(R.id.E4_2_1_user);
            TextView password=(TextView)findViewById(R.id.E4_2_1_password);
            @Override
            public void onClick(View v) {
                String userString=user.getText().toString();
                String passwordString=password.getText().toString();
                Intent intent=new Intent(experiment_4_2_1.this,com.example.admin.myapplication.experiment_4_2_2.class);
                intent.putExtra("user",userString);
                intent.putExtra("password",passwordString);
                startActivity(intent);
            }
        });
        Button confirm=(Button)findViewById(R.id.E4_2_1_confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(experiment_4_2_1.this,experiment_4_2_3.class);
                startActivity(intent);
            }
        });
        TextView status=(TextView)findViewById(R.id.E4_2_1_status);
        Intent currentIntent=getIntent();
        final int item=currentIntent.getIntExtra("itemNum",-1);
        if(item==-1)
        {
            status.setText("你未选择任何的item");
        }
        else{
            status.setText("你选择了item"+(item+1));
        }



    }
}
