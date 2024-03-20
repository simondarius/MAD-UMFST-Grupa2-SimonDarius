package com.example.lab5ex3;

import java.util.ArrayList;

public class ContactListClass {
    static ArrayList<Contact> contacts = new ArrayList<>();

    static {
        contacts.add(new Contact("Precup", "Serban", "0742384580", "precup.serban@email.com", "Reghin"));
        contacts.add(new Contact("Simon", "Darius", "0757656987", "simon.darius@email.com", "Reghin"));
        contacts.add(new Contact("Cofariu", "Tudor", "0745156083", "cofariu.tudor@email.com", "Tg. Mures"));
        contacts.add(new Contact("Toncean", "Catalin", "0740184743", "toncean.catalin@email.com", "Reghin"));
        contacts.add(new Contact("Moldovan", "Carloss", "0760813920", "moldovan.carloss@email.com", "Toaca"));
    }
}