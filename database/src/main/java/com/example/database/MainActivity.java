package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.example.database.R;

public class MainActivity extends AppCompatActivity {

    private com.example.database.MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.database.R.layout.activity_main);

        dbHelper = new com.example.database.MyDatabaseHelper(this);

        dbHelper.deleteAllData();
        dbHelper.insertData("John", 25);
        dbHelper.insertData("Luke", 26);

        getData();

        dbHelper.updateData(2, "Mark", 26);

        getData();

        dbHelper.deleteData(2);

        getData();

        SharedPreferences prefs = getSharedPreferences("my_prefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", "John");
        editor.putInt("age", 26);
        editor.putBoolean("is_student", true);
        editor.commit();

        String name = prefs.getString("name", "");
        int age = prefs.getInt("age", 0);
        boolean isStudent = prefs.getBoolean("is_student", false);
        Log.d("MainActivity", name);
        Log.d("MainActivity", String.valueOf(age));
        Log.d("MainActivity", String.valueOf(isStudent));

        editor.remove("name");
        editor.apply();

        name = prefs.getString("name", "");
        age = prefs.getInt("age", 0);
        isStudent = prefs.getBoolean("is_student", false);
        Log.d("MainActivity", name);
        Log.d("MainActivity", String.valueOf(age));
        Log.d("MainActivity", String.valueOf(isStudent));

        editor.clear();
        editor.commit();

        name = prefs.getString("name", "");
        age = prefs.getInt("age", 0);
        isStudent = prefs.getBoolean("is_student", false);
        Log.d("MainActivity", name);
        Log.d("MainActivity", String.valueOf(age));
        Log.d("MainActivity", String.valueOf(isStudent));

    }

    @SuppressLint("Range")
    private void getData(){
        Cursor cursor = dbHelper.getData();

        Log.d("MainActivity", "======START======");
        if (cursor.getCount() > 0){
            while(cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));

                Log.d("MainActivity", "Records retrieved with ID: " + id + ", name: " + name + ", age: " + age);
            }
        }else{
            Log.d("MainActivity", "No record found.");
        }
        Log.d("MainActivity", "======END======");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(dbHelper != null){
            dbHelper.close();
        }

    }

}