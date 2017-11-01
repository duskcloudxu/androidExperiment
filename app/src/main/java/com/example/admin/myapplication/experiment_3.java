package com.example.admin.myapplication;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class experiment_3 extends AppCompatActivity {
    private String[] data = {"Item1", "Item2", "Item3", "Item4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_3);
        ListView listView = (ListView) findViewById(R.id.E3_listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, data);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("test", "onItemSelected: test");
                Toast.makeText(experiment_3.this, "你选中了" + parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });
        Button sipAlt = (Button) findViewById(R.id.E3_simpleAlert);
        Button cplAlt = (Button) findViewById(R.id.E3_complicatedAlert);
        sipAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(experiment_3.this);
                dlg.setMessage("Good night").setNegativeButton("取消", null)
                        .setPositiveButton("确定", null)
                        .setNeutralButton("帮助", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(experiment_3.this, "I need help", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        cplAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(experiment_3.this);
                final String[] data = {"Math", "English", "Physic"};
                dlg.setMultiChoiceItems(data, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            Toast.makeText(experiment_3.this, data[which], Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                        .show();
            }
        });
        TimePicker timePicker = (TimePicker) findViewById(R.id.E3_timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(experiment_3.this, "现在为" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        });
        Button timelog = (Button) findViewById(R.id.E3_timeLog);
        timelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cld = Calendar.getInstance();
                Toast.makeText(experiment_3.this, "test", Toast.LENGTH_SHORT).show();
                TimePickerDialog tpd = new TimePickerDialog(experiment_3.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(experiment_3.this, "You selected:" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                    }
                }, cld.get(Calendar.HOUR_OF_DAY), cld.get(Calendar.MINUTE), false);
                tpd.show();
            }
        });

        Button vBtn = (Button) findViewById(R.id.E3_visButton);
        Button plusBtn = (Button) findViewById(R.id.E3_plusButton);
        Button minusBtn = (Button) findViewById(R.id.E3_minusButton);
        vBtn.setOnClickListener(new View.OnClickListener() {
            ProgressBar pBar = (ProgressBar) findViewById(R.id.E3_oriProcessBar);

            @Override
            public void onClick(View v) {
                if (pBar.getVisibility() == View.VISIBLE)
                    pBar.setVisibility(View.INVISIBLE);
                else
                    pBar.setVisibility(View.VISIBLE);
            }
        });
        plusBtn.setOnClickListener(new View.OnClickListener() {
            ProgressBar pBar = (ProgressBar) findViewById(R.id.E3_horiProcessBar);

            @Override
            public void onClick(View v) {
                int current = pBar.getProgress();
                current += current * 0.1;
                pBar.setProgress(current);
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            ProgressBar pBar = (ProgressBar) findViewById(R.id.E3_horiProcessBar);

            @Override
            public void onClick(View v) {
                int current = pBar.getProgress();
                current -= current * 0.1;
                pBar.setProgress(current);
            }
        });
        final SeekBar seekBar = (SeekBar) findViewById(R.id.E3_seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            TextView text = (TextView) findViewById(R.id.E3_seekBarStatus);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text.setText("当前位置" + seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                text.setText("当前位置" + seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                text.setText("拖动滑块设置");
            }
        });


    }
}
