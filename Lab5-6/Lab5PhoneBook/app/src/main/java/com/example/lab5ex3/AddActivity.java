package com.example.lab5ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddActivity extends AppCompatActivity {

    TextInputEditText name,surname,phone,adress,email;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnAdd=findViewById(R.id.btnAdd);

        name = findViewById(R.id.txtName);
        surname = findViewById(R.id.txtSurname);
        phone = findViewById(R.id.txtPhone);
        email = findViewById(R.id.txtEmail);
        adress = findViewById(R.id.txtAdress);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((name.getText().toString().isEmpty()) && (surname.getText().toString().isEmpty()))
                {
                    Toast.makeText(AddActivity.this, "COMPLETATI MACAR UN NUME!!!", Toast.LENGTH_SHORT).show();
                }
                else if (phone.getText().toString().isEmpty()) {
                    Toast.makeText(AddActivity.this, "COMPLETATI NUMARUL DE TELEFON!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    String name1,surname1,phone1,adress1,email1;
                    if(name.toString().isEmpty())
                        name1=" ";
                    else
                        name1=name.getText().toString();
                    if(surname.toString().isEmpty())
                        surname1=" ";
                    else
                        surname1=surname.getText().toString();
                    if(phone.toString().isEmpty())
                        phone1=" ";
                    else
                        phone1=phone.getText().toString();
                    if(adress.toString().isEmpty())
                        adress1=" ";
                    else
                        adress1=adress.getText().toString();
                    if(email.toString().isEmpty())
                        email1=" ";
                    else
                        email1=email.getText().toString();
                    ContactListClass.contacts.add(new Contact(name1,surname1,phone1,email1,adress1));
                    Intent intent = new Intent(AddActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}