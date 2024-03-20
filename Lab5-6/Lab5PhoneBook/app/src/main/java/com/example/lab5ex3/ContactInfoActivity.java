package com.example.lab5ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ContactInfoActivity extends AppCompatActivity {

    TextInputEditText name, surname, phone, eMail, adress;
    Button btnSave, btnDelete,btnCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        Intent intent = getIntent();
        int position = (int) intent.getSerializableExtra("position");
        Contact contact = ContactListClass.contacts.get(position);

        name = findViewById(R.id.txtName);
        surname = findViewById(R.id.txtSurname);
        phone = findViewById(R.id.txtPhone);
        eMail = findViewById(R.id.txtEmail);
        adress = findViewById(R.id.txtAdress);

        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        btnCall = findViewById(R.id.btnCall);

        name.setText(contact.name);
        surname.setText(contact.surname);
        phone.setText(contact.phone);
        eMail.setText(contact.email);
        adress.setText(contact.adress);

        name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                name.setInputType(InputType.TYPE_CLASS_TEXT);
                return false;
            }
        });

        surname.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                surname.setInputType(InputType.TYPE_CLASS_TEXT);
                return false;
            }
        });

        phone.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                phone.setInputType(InputType.TYPE_CLASS_TEXT);
                return false;
            }
        });

        eMail.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                eMail.setInputType(InputType.TYPE_CLASS_TEXT);
                return false;
            }
        });

        adress.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                adress.setInputType(InputType.TYPE_CLASS_TEXT);
                return false;
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactListClass.contacts.set(position, new Contact(name.getText().toString(), surname.getText().toString(), phone.getText().toString(), eMail.getText().toString(), adress.getText().toString()));
                Intent intent=new Intent(ContactInfoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactListClass.contacts.remove(position);
                Intent intent=new Intent(ContactInfoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = ContactListClass.contacts.get(position).phone;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if(intent.resolveActivity(getPackageManager()) !=null)
                {
                    startActivity(intent);
                }
            }
        });

    }
}