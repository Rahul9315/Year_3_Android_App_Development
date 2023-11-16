package com.example.progressionbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private BackgroundThread backgroundThread;

    private Runnable task1 = () -> {
        for (int i = 0; i < 10; i++) {
            SystemClock.sleep(1000);
            updateProgressBar(i, 1);
        }
    };

    private Runnable task2 = () -> {
        for (int i = 0; i < 100; i++) {
            updateProgressBar(i, 2);
        }
    };
    private Runnable task3 = () -> {
        for (int i = 0; i < 10; i++) {
            SystemClock.sleep(1000);
            updateProgressBar(i, 3);
        }
    };

    private Runnable task4 = () -> {
        for (int i = 0; i < 100; i++) {
            updateProgressBar(i, 4);
        }
    };
        private Runnable task5 = () -> {
            for (int i = 0; i < 100; i++) {
                updateProgressBar(i, 5);
            }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundThread = new BackgroundThread();
        backgroundThread.start();

        Button startButton = findViewById(R.id.start);
        Button resetButton = findViewById(R.id.reset);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backgroundThread.addTaskToMessageQueue(task1);
                backgroundThread.addTaskToMessageQueue(task2);
                backgroundThread.addTaskToMessageQueue(task3);
                backgroundThread.addTaskToMessageQueue(task4);
                backgroundThread.addTaskToMessageQueue(task5);

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetProgressBars();
            }
        });
    }

    private void updateProgressBar(int progress, int progressBarNumber) {
        runOnUiThread(() -> {
            String progressBarId = "progressbar" + progressBarNumber;
            int resId = getResources().getIdentifier(progressBarId, "id", getPackageName());
            ProgressBar progressBar = findViewById(resId);
            progressBar.setProgress(progress);
            updateProgressEditText(); // Update progress EditText
        });
    }

    private void resetProgressBars() {
        runOnUiThread(() -> {
            for (int i = 1; i <= 5; i++) {
                String progressBarId = "progressbar" + i;
                int resId = getResources().getIdentifier(progressBarId, "id", getPackageName());
                ProgressBar progressBar = findViewById(resId);
                progressBar.setProgress(0);
            }
            updateProgressEditText(); // Update progress EditText
        });
    }

    private void updateProgressEditText() {
        runOnUiThread(() -> {
            int totalProgress = 0;
            for (int i = 1; i <= 5; i++) {
                String progressBarId = "progressbar" + i;
                int resId = getResources().getIdentifier(progressBarId, "id", getPackageName());
                ProgressBar progressBar = findViewById(resId);
                totalProgress += progressBar.getProgress();
            }

            int totalBars = 5;
            int percentage = (totalProgress * 100) / (10 * totalBars);

            EditText progressEditText = findViewById(R.id.progressEditText);
            progressEditText.setText(percentage + "%");
        });
    }
}
