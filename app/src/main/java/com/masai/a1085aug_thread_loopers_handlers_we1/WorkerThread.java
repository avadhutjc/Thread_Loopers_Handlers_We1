package com.masai.a1085aug_thread_loopers_handlers_we1;

import android.os.Handler;
import android.os.Looper;

public class WorkerThread extends Thread {
    private Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare(); //now thread is alive it is like creating instant
        handler = new Handler(Looper.myLooper());
        Looper.loop();
    }

    public void addTaskToMessageQueue(Runnable task) {

        if (handler != null) { //condition for safety
            handler.post(task);
        }
    }

}
