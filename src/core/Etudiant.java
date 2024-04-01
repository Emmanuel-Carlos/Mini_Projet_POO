package core;

import interface_graphique.MainFrmApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Etudiant extends  Contact {
    public String cycle;
    public String niveau;

    public Etudiant(String code, String nom, String date_de_naissance, String address, String email, String telNumber, String cycle, String niveau) {
        super(code, nom, date_de_naissance, address, email, telNumber);
        this.cycle = cycle;
        this.niveau = niveau;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    @Override
    public void inserer_contact_BD(Connection connection) {

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO ETUDIANT VALUES(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, nom);
            preparedStatement.setString(3, date_de_naissance);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, telNumber);
            preparedStatement.setString(7, cycle);
            preparedStatement.setString(8, niveau);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}