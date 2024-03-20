package com.cnidaria.lab5intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToActivity1(View view) {
        Intent intent = new Intent(this, Activity1.class);
        startActivity(intent);
    }


    public void goToActivity2(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }


    public void goToActivity3(View view) {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}