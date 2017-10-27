package com.example.admin.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class messageRight extends LinearLayout {
    private String displayText;
    private TextView textView;
    public messageRight(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.sample_message_right,this);
        textView=(TextView)findViewById(R.id.messageRight_text);
    }


    public messageRight(Context context, String displayText) {
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
