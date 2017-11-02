package com.example.admin.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class experiment_5 extends AppCompatActivity {
    private Menu M;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.experiment_5_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "you clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.experiment_5_context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        ListView listview = (ListView) findViewById(R.id.E5_listView);
        int selected = 0;
        for (int i = 0; i < listview.getCount(); i++) {
            if (listview.getItemIdAtPosition(i) == info.id) {
                selected = i;
                break;
            }
        }
        TextView text = (TextView) findViewById(R.id.E5_testStatus);
        text.setText(listview.getItemAtPosition(selected).toString() + item.getTitle());
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_5);
        final Button popUp = (Button) findViewById(R.id.E5_popUp);
        popUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu = new PopupMenu(experiment_5.this, popUp);
                M = menu.getMenu();
                M.add(0, 1, 0, "红色");
                M.add(0, 2, 0, "蓝色");
                M.add(0, 3, 0, "绿色");
//                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    TextView text = (TextView) findViewById(R.id.E5_testStatus);
//
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.E5_red: {
//                                text.setTextColor(Color.RED);
//                                break;
//                            }
//                                case R.id.E5_blue: {
//                                text.setTextColor(Color.BLUE);
//                                break;
//                            }
//                            case R.id.E5_green: {
//                                text.setTextColor(Color.GREEN);
//                                break;
//                            }
//                        }
//                        return false;
//                    }
//                });
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    TextView text = (TextView) findViewById(R.id.E5_testStatus);

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case 1: {
                                text.setTextColor(Color.RED);
                                break;
                            }
                            case 2: {
                                text.setTextColor(Color.BLUE);
                                break;
                            }
                            case 3: {
                                text.setTextColor(Color.GREEN);
                                break;
                            }
                        }
                        return false;
                    }
                });
                menu.show();
            }
        });
        final Button radio = (Button) findViewById(R.id.E5_radio);
        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu = new PopupMenu(experiment_5.this, radio);
                menu.getMenuInflater().inflate(R.menu.experiment_5_radio_group, menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        item.setChecked(true);
                        Toast.makeText(experiment_5.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                menu.show();
            }
        });
        ListView listview = (ListView) findViewById(R.id.E5_listView);
        String[] data = {"好き", "嫌い", "I do not care"};
        ArrayAdapter<String> arrayatp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, data);
        listview.setAdapter(arrayatp);
        registerForContextMenu(listview);


    }
}
