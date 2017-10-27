package com.example.admin.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * container of right messages.
 */

public class message_adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<String> items;
    private List<Boolean> LR;//0 means left, 1 means right

    public message_adapter(Context context, List<String> items, List<Boolean> LR) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
        this.LR = LR;
    }

    public void addMessage(Boolean lr, String message) {
        items.add(message);
        LR.add(lr);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public String getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.items.get(position).hashCode();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    @TargetApi(23)
    public View getView(int position, View convertView, ViewGroup parent) {
        if (LR.get(position)) {
            convertView = inflater.inflate(R.layout.sample_message_right, parent, false);
        } else {
            convertView = inflater.inflate(R.layout.sample_message_left, parent, false);
        }
        String item = items.get(position);
        TextView text = (TextView) convertView.findViewById(R.id.messageRight_text);
        text.setText(item);
        return convertView;
    }
}
