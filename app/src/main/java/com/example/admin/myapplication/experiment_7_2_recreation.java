package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class experiment_7_2_recreation extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_experiment_7_2_recreation, container, false);
        ImageView imageView=(ImageView) view.findViewById(R.id.E7_2_recreation_imgview);
        Drawable drawable=getResources().getDrawable(R.mipmap.b);
        imageView.setImageDrawable(drawable);
        return view;
    }

}
