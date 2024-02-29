package com.cnidaria.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonAdd = findViewById(R.id.button2);
        Button buttonToast = findViewById(R.id.button);
        TextView counter=findViewById(R.id.counter);
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Value of counter is : "+counter.getText().toString(), Toast.LENGTH_SHORT).show();
            }
          }
        );
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                counter.setText(String.valueOf(Integer.parseInt(counter.getText().toString()) +1));
            }
        }
        );
    }

}