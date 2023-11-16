package com.example.progressionbar;

import android.os.Handler;
import android.os.Looper;

public class BackgroundThread extends Thread {

    private Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare(); // Associating thread
        handler = new Handler();
        Looper.loop();
    }

    /**
     * This method is used to add different tasks to the message queue
     *
     * @param task
     */
    public void addTaskToMessageQueue(Runnable task) {
        handler.post(task); // First task1 is added to the queue then task2.
    }
}


