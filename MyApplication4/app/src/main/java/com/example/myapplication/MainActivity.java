package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private Button submit;
    private TextView result;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
        submit = findViewById(R.id.submit);
        result = findViewById(R.id.result);
        image = findViewById(R.id.imageView);

        //image.setImageResource(R.drawable.ic_launcher_background);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                String username = name.getText().toString();
                result.setText(username);
                image.setImageResource(R.drawable.animal_animal_photography_cat_feline_kitten_paws_pet_tabby_4896x3010);
            }
        });

    }
}