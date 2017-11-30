package com.example.admin.myapplication;

import android.os.Handler;
import android.os.Message;

/**
 * Created by duskcloud on 2017/11/23.
 */

public class progress extends Thread {
    private String buttonName;
    private int ascend;
    private Handler notice;

    public progress(Handler target, String btnName, int asc) {
        ascend = asc;
        buttonName = btnName;
        notice = target;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = new Message().obtain(notice);
                msg.what = 0;
                msg.arg1 = ascend;
                msg.obj = buttonName;
                msg.sendToTarget();
                this.sleep(3000);
                if(this.interrupted())throw new InterruptedException();
            }
        } catch (InterruptedException except) {
return;
        }
    }

    @Override
    public void interrupt() {

        super.interrupt();
    }
}
