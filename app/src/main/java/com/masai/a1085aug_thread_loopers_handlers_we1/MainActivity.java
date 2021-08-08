package com.masai.a1085aug_thread_loopers_handlers_we1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button task1, task2;
    WorkerThread workerThread;
    private static final String TAG = MainActivity.class.getName();

    private static Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "Task One " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private static Runnable taskTwo = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "Task Two " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000); //3sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workerThread = new WorkerThread();
        workerThread.start();

        task1 = findViewById(R.id.btn1);
        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskOne);
            }
        });

        task2 = findViewById(R.id.btn2);
        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskTwo);
            }
        });
    }
}