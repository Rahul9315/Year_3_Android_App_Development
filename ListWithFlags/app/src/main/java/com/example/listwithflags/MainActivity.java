package com.example.listwithflags;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String countryNames[] = {
            "India",
            "Chins",
            "Nepal",
            "Bhutan"
    };

    private String capitalNames[] = {
            "Delhi",
            "Beijing",
            "Kathmandu",
            "Thimphu"
    };

    private Integer imageid[] = {
            R.drawable.india,
            R.drawable.china,
            R.drawable.nepal,
            R.drawable.bhutan
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting Header
        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("List Of Countries");

        ListView listView = (ListView) findViewById(R.id.list);

        listView.addHeaderView(textView);

        // for populating list data
        CustomCountryList customCountryList =new CustomCountryList(this,countryNames,capitalNames,imageid);
        listView.setAdapter(customCountryList);









    }
}