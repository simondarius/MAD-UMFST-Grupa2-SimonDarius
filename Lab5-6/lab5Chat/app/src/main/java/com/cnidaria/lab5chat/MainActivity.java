package com.cnidaria.lab5chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textInput1;
    FloatingActionButton btnSend;
    TextView txtSwitch;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInput1 = findViewById(R.id.Msg);
        btnSend = findViewById(R.id.btnSend);
        textView = findViewById(R.id.textMesaje);
        txtSwitch = findViewById(R.id.txtSwitch);

        textView.setText(Messages.message);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textInput1.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Input here..", Toast.LENGTH_SHORT).show();
                else{
                    String textP1 ="P1:" + textInput1.getText().toString();
                    textView.append("\n");
                    textView.append(textP1);
                    Messages.message=Messages.message.concat("\n" + textP1);
                }
            }
        });

        txtSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UserActivity1.class);
                startActivity(intent);
            }
        });

    }
}