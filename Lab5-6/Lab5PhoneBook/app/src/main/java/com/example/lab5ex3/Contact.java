package com.example.lab5ex3;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Serializable {
    String name;
    String surname;
    String email;
    String phone;
    String adress;

    Contact(String name,String surname,String phone,String email,String adress){
        this.name=name;
        this.surname=surname;
        this.phone=phone;
        this.email=email;
        this.adress=adress;
    }

}
