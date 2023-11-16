package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;

public class ReadImage {
    public static Bitmap readImage(String address){
        Bitmap bitmapImage = null;
        try{
            InputStream inputStream = new URL(address).openStream();
            bitmapImage = BitmapFactory.decodeStream(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (bitmapImage == null)
            Log.d("Message","The image was not fetched");
        return bitmapImage;
    }
}
