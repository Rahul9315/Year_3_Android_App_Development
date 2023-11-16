package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView country_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country_list = findViewById(R.id.country_list);
        ArrayList<String> city_array = new ArrayList<>();
        city_array.add("Shanghai");
        city_array.add("Tokyo");
        city_array.add("Dublin");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, city_array);
        country_list.setAdapter(adapter);

        country_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedCity = city_array.get(i);
                Toast.makeText(MainActivity.this, "You just Clicked " + selectedCity, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this , DisplayInfo.class);

                Bundle b = new Bundle();
                b.putString("City", selectedCity);


                if (selectedCity.equals("Shanghai")) {
                    b.putString("country", "China");
                    b.putInt("city_population", 24153000);
                    b.putInt("metro_population", 34000000);
                } else if (selectedCity.equals("Tokyo")) {
                    b.putString("country", "Japan");
                    b.putInt("city_population", 43000);
                    b.putInt("metro_population", 500000);
                } else if (selectedCity.equals("Dublin")) {
                    b.putString("country", "Ireland");
                    b.putInt("city_population", 643000);
                    b.putInt("metro_population", 560000);
                }

                intent.putExtras(b);
                startActivity(intent);
            }
        });



    }
}