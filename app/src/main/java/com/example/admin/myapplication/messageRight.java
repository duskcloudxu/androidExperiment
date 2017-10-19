package com.example.admin.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class messageRight extends LinearLayout {
    private TextView text=(TextView)findViewById(R.id.messageRight_text);
    public messageRight(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.sample_messageRight,this);
    }
    public void setText(String targetText){
        text.setText(targetText);
    }


}
