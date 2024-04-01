package core;

import interface_graphique.MainFrmApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Enseignant extends Contact
{
    public String statut;
    public Enseignant(String code, String nom, String date_de_naissance, String address, String email, String telNumber, String statut)
    {
        super(code,nom,date_de_naissance,address,email,telNumber);
        this.statut=statut;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public void inserer_contact_BD(Connection connection) {

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO ENSEIGNANT VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, nom);
            preparedStatement.setString(3, date_de_naissance);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, telNumber);
            preparedStatement.setString(7, statut);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
