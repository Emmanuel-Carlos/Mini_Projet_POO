package core;

import java.sql.Connection;


public abstract class Contact
{
    public  String code;
    public  String nom;
    public String date_de_naissance;
    public  String address;
    public  String email;
    public  String telNumber;

    public Contact(String code,String nom,String date_de_naissance,String address,String email,String telNumber)
    {
        this.code=code;
        this.nom=nom;
        this.date_de_naissance=date_de_naissance;
        this.address=address;
        this.email=email;
        this.telNumber=telNumber;
    }

    ///Les getters
    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    ///Les setters

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public abstract void  inserer_contact_BD(Connection connection);
}


