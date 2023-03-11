package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class  MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "This is a vebose log.");
        Log.d(TAG, "This is a debug log.");
        Log.i(TAG, "This is a info log.");
        Log.w(TAG, "This is a war log.");
        Log.e(TAG, "This is a error log.");

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button Click");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);


            }
        });
    }
}