package com.example.admin.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class experiment_6 extends AppCompatActivity {
    private Intent mIntent;
    private musicService mMusicService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment_6);
        mIntent = new Intent(experiment_6.this, updateService.class);
        Button updateStartBtn = (Button) findViewById(R.id.E6_startUpdateServiceBtn);
        updateStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("btn", "onClick: test");
                startService(mIntent);
            }
        });
        Button updateCloseBtn = (Button) findViewById(R.id.E6_closeUpdateServiceBtn);
        updateCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(mIntent);
            }
        });
        Button musicStart = (Button) findViewById(R.id.E6_openMusicServiceBtn);
        Intent mIntent = new Intent(experiment_6.this, musicService.class);
        bindService(mIntent, musicConnection, BIND_AUTO_CREATE);
        musicStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMusicService.playMusic();
            }
        });
        Button musicStop=(Button)findViewById(R.id.E6_closeMusicServiceBtn);
        musicStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMusicService.stop();
            }
        });
    }

    private ServiceConnection musicConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMusicService = ((musicService.musicBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
