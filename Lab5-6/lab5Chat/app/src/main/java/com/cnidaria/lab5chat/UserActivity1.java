package com.cnidaria.lab5chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class UserActivity1 extends AppCompatActivity {

    TextInputEditText textInput2;
    FloatingActionButton btnSend;

    TextView txtSwitch;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user1);

        textInput2 = findViewById(R.id.Msg);
        btnSend = findViewById(R.id.btnSend);
        textView = findViewById(R.id.textMesaje);
        txtSwitch = findViewById(R.id.txtSwitch);

        textView.setText(Messages.message);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textInput2.getText().toString().isEmpty())
                    Toast.makeText(UserActivity1.this, "Scrie ceva!", Toast.LENGTH_SHORT).show();
                else{
                    String textP2 ="P2:" + textInput2.getText().toString();
                    textView.append("\n");
                    textView.append(textP2);
                    Messages.message=Messages.message.concat("\n" + textP2);
                }
            }
        });

        txtSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity1.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}