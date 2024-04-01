package core;

import interface_graphique.MainFrmApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Agent extends Contact
{
    public String statut;
    public int salaire;
    public String categorie;
    public int indice_de_salaire;
    public String occupation;

    public Agent(String code, String nom, String date_de_naissance, String address, String email, String telNumber, String statut,int salaire,String categorie,int indice_de_salaire,String occupation)
    {
        super(code,nom,date_de_naissance,address,email,telNumber);
        this.statut=statut;
        this.salaire=salaire;
        this.categorie=categorie;
        this.indice_de_salaire=indice_de_salaire;
        this.occupation=occupation;
    }

    ///les getters
    public String getStatut() {
        return statut;
    }

    public int getSalaire() {
        return salaire;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getIndice_de_salaire() {
        return indice_de_salaire;
    }

    public String getOccupation() {
        return occupation;
    }

    ///les setters
    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setIndice_de_salaire(int indice_de_salaire) {
        this.indice_de_salaire = indice_de_salaire;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }


    @Override
    public void inserer_contact_BD(Connection connection) {

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO AGENT VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, nom);
            preparedStatement.setString(3, date_de_naissance);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, telNumber);
            preparedStatement.setInt(7, salaire);
            preparedStatement.setString(8, statut);
            preparedStatement.setString(9, categorie);
            preparedStatement.setInt(10, indice_de_salaire);
            preparedStatement.setString(11, occupation);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
