package com.example.admin.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class musicService extends Service {
    private IBinder mIBinder = new musicBinder();
    private MediaPlayer mMediaPlay = null;

    public musicService() {
    }

    public void playMusic() {
        if(mMediaPlay!=null)mMediaPlay.reset();
        mMediaPlay = MediaPlayer.create(this, R.raw.music_demo1);
        mMediaPlay.start();
    }

    public void stop() {
        mMediaPlay.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mIBinder;
    }

    public class musicBinder extends Binder {
        musicService getService() {
            return musicService.this;
        }
    }
}
