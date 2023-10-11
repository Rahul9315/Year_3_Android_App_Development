package com.example.myapplication2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication2.ui.theme.MyApplication2Theme
import java.nio.file.attribute.AclFileAttributeView


class MainActivity : ComponentActivity() {

    lateinit var name: EditText
    lateinit var submit: Button
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        name = findViewById(R.id.editText)
        submit = findViewById(R.id.button)
        result = findViewById(R.id.results)

        submit.setOnClickListener {
            var username : String
            username = name.text.toString()
            result.setText(username)
        }
}

}
