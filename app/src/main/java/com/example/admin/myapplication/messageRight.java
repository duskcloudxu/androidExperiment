package com.example.admin.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;


public class messageRight extends LinearLayout {
    private TextView text=(TextView)findViewById(R.id.messageRight_text);
    public messageRight(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.sample_message_right,this);
    }
    public void setText(String targetText){
        text.setText(targetText);
    }


}
