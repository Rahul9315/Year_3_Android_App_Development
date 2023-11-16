package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.net.URL;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private TextView outputText;
    private ImageView imageView;
    private static final String TAG = "IT472";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputText = findViewById(R.id.outputText);
    }

    public void runTask(View v){
        // Runnung a task on th eUI thread
        //Log.i(TAG,"Blocking Task Started");

        Thread thread = new Thread(){
            public void run(){
                Log.i(TAG,"Thread Started");
                try{
                    //simulate a long-running task
                    Thread.sleep(10000);//wait 10sec
                    //outputText.setText("Task Complete");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG,"Thread Finished");
            }
        };
        thread.start();

    }

    public void generateContent(View view) {
        outputText.setText("Random number: " + Math.random() );

        //generate services to execute threads
        ExecutorService service = Executors.newSingleThreadExecutor();
        //create a handle to recover the result from the
        Handler handler = new Handler(Looper.getMainLooper());

        service.execute(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = ReadImage.readImage("https://picsum.photos/200/300/?random\n"); //read image
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //fill this function to set the image
                            if (bitmap != null) {
                                imageView.setImageBitmap(bitmap);
                            } else {
                                Log.d("Message", "The image was not fetched");
                            }
                        }
                    });
            }
        });

    }




}