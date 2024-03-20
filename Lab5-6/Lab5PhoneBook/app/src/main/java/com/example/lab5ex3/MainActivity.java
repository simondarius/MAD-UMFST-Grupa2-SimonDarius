package com.example.lab5ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView contactsList;
    FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsList=findViewById(R.id.contactsList);

        btnAdd=findViewById(R.id.btnAdd);

        ArrayList<String> contactsNames = new ArrayList<>();
        for(Contact c:ContactListClass.contacts)
        {
           contactsNames.add(c.name +" "+ c.surname);
        }

        ArrayAdapter<String> contactsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contactsNames
        );

        contactsList.setAdapter(contactsAdapter);

        contactsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,ContactInfoActivity.class);
//                intent.putExtra("contact",contactSelectat);
//                intent.putExtra("contacts", finalContacts);
                intent.putExtra("position",position);
//                Toast.makeText(MainActivity.this,String.valueOf(position), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });
    }
}