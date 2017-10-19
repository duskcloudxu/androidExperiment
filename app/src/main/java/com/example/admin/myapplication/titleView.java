package com.example.admin.myapplication;
import android.app.Activity;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class titleView extends LinearLayout {

    public titleView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.sample_title_view,this);
        Button back=(Button)findViewById(R.id.titleView_buttonLeft);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ((Activity)context).finish();
            }
        });

    }
}
