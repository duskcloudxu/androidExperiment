package com.example.admin.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WeChatSimulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat_simulation);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)actionBar.hide();//隐藏默认顶栏
        ListView listView=(ListView)findViewById(R.id.Wechat_listView);
        listView.setDivider(null);
        List<String>messageRightList=new ArrayList<>();
        List<Boolean>LR=new ArrayList<>();
        messageRightList.add("黄志太强啦");
        LR.add(false);//右边增加
        messageRightList.add("是啊");
        LR.add(true);//左边增加
        final message_adapter mra=new message_adapter(WeChatSimulation.this,messageRightList,LR);
        listView.setAdapter(mra);
        Button send=(Button)findViewById(R.id.Wechat_sendBtn);
        send.setOnClickListener(new View.OnClickListener() {
            EditText editText=(EditText)findViewById(R.id.Wechat_edit);
            @Override
            public void onClick(View v) {
                String newMessage=editText.getText().toString();
                if(newMessage.length()==0)return;
                editText.setText("");
                mra.addMessage(true,newMessage);
            }
        });

    }
}
