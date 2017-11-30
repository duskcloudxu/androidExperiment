package com.example.admin.myapplication;

import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class updateService extends Service {
    private NotificationManager mNotificationManager;
    private NotificationCompat.Builder mBuilder;
    private notificationThread mNotification;

    public updateService() {
    }

    @Override
    public void onCreate() {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("testTitle");
        mBuilder.setContentInfo("testinfo");
        mNotification = new notificationThread();
        mNotification.start();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        mNotification.interrupt();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;

    }

    public class notificationThread extends Thread {

        @Override
        public void run() {

            try {
                int i=0;
                while (true) {

                    mNotificationManager.notify(i++, mBuilder.build());
                    Log.d("thread", "run: exist ");
                    this.sleep(3000);
                    if (isInterrupted()) throw new InterruptedException("boom");
                }
            } catch (InterruptedException consumed) {
                return;
            }
        }
    }

}
