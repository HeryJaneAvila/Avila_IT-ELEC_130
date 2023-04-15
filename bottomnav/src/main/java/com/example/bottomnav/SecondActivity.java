package com.example.bottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bottomnav.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.text_second);

        Intent intent = getIntent();

        String fromMain = intent.getStringExtra("PASS_ME");

        textView.setText(fromMain);
    }
}