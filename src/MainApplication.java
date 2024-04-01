import core.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainApplication {
    public static void main(String[] args) throws SQLException {
        ArrayList<Contact> contacts = new ArrayList<>();
        Etudiant etudiant=new Etudiant("003","pekka","10-10-05","yaounde","pekka.com","654242122","Licence","1");
        Enseignant enseignant=new Enseignant("10","djongo","09-02-90","douala","djongo.com","687456312","vacataire");
        Agent agent=new Agent("25","carl","10-08-05","yaounde","carl.com","698562122","vacataire",10000,"ca",20,"jeu video");


        Repertoire repertoire=new Repertoire(contacts);

        repertoire.ajouter_contact(etudiant);
        repertoire.ajouter_contact(enseignant);
        repertoire.ajouter_contact(agent);

        repertoire.rechercher_contact(enseignant);

        repertoire.supprimer_contact(agent);

       for (Contact contact: repertoire.liste_contacts)
        {
            System.out.println(contact);
        }

        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root","2005emma");
        System.out.println("connexion reussie");
        etudiant.inserer_contact_BD(connection);
       enseignant.inserer_contact_BD(connection);
       agent.inserer_contact_BD(connection);

    }
}