package com.example.admin.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;


public class messageLeft extends LinearLayout {
    private String displayText;
    private TextView textView;
    public messageLeft(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.sample_message_right,this);
        textView=(TextView)findViewById(R.id.messageRight_text);
    }


    public messageLeft(Context context, String displayText) {
        super(context);

    }
    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
        textView.setText(displayText);
    }


}
