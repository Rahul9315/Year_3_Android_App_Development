package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        Bundle b = getIntent().getExtras();
        String city = b.getString("City");
        String country = b.getString("country");
        int city_population = b.getInt("city_population");
        int metro_population = b.getInt("metro_population");

        TextView display_country = (TextView) findViewById(R.id.display_country);
        TextView display_city = (TextView) findViewById(R.id.display_city);
        TextView display_population = (TextView) findViewById(R.id.display_population);
        TextView display_metropolitan = (TextView) findViewById(R.id.display_metropolitan);

        display_country.setText(country);
        display_city.setText(city);
        display_metropolitan.setText(String.valueOf(metro_population));
        display_population.setText(String.valueOf(city_population));
    }
}