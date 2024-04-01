package interface_graphique;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repertoire extends  JFrame{
    private JPanel panel1;
    private JPanel panelPrincipal;
    private JPanel libelle;
    private JPanel contacts;
    private JTabbedPane tabbedPane1;
    private JTable listeEtudiant;
    private JTable listeEnseignant;
    private JTable listeAgent;
    private JPanel panelEtudiant;
    private JPanel panelEnseignant;
    private JPanel panelAgent;

    public Repertoire()
    {
        setContentPane(panelPrincipal);
        setTitle("Repertoire");
        setVisible(true);
        setSize(700,600);


    }

    public  void tableEtudiant()
    {


        try {
            String[] etudiant={"CODE","NOM","DATE DE NAISSANCE","ADDRESSE","EMAIL","TELNUMBER","CYCLE","NIVEAU"};
            String[] afficher=new String[8];

            MainFrmApplication.connect();
            Statement statement =MainFrmApplication.connection.createStatement();
            ResultSet resulset=statement.executeQuery("SELECT * FROM ETUDIANT");
            DefaultTableModel model=new DefaultTableModel(null,etudiant);

            while (resulset.next())
            {
                afficher[0]=resulset.getString("code");
                afficher[1]=resulset.getString("nom");
                afficher[2]=resulset.getString("date_naissance");
                afficher[3]=resulset.getString("address");
                afficher[4]=resulset.getString("email");
                afficher[5]=resulset.getString("telnumber");
                afficher[6]=resulset.getString("cycle");
                afficher[7]=resulset.getString("niveau");
                model.addRow(afficher);
            }
            listeEtudiant.setModel(model);
            listeEtudiant.getTableHeader().setVisible(true);
            MainFrmApplication.connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public  void tableEnseignant() {
        String[] enseignant = {"CODE", "NOM", "DATE DE NAISSANCE", "ADDRESSE", "EMAIL", "TELNUMBER", "STATUT"};
        String[] afficher = new String[7];
        DefaultTableModel model = new DefaultTableModel(null, enseignant);
        try {
            MainFrmApplication.connect();
            Statement statement = MainFrmApplication.connection.createStatement();
            ResultSet resulset = statement.executeQuery("SELECT * FROM ENSEIGNANT");

            while (resulset.next()) {
                afficher[0] = resulset.getString("code");
                afficher[1] = resulset.getString("nom");
                afficher[2] = resulset.getString("date_naissance");
                afficher[3] = resulset.getString("address");
                afficher[4] = resulset.getString("email");
                afficher[5] = resulset.getString("telnumber");
                afficher[6] = resulset.getString("statut");
                model.addRow(afficher);
            }
            listeEnseignant.setModel(model);
            MainFrmApplication.connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public  void tableAgent() {
        String[] agent = {"CODE", "NOM", "DATE DE NAISSANCE", "ADDRESSE", "EMAIL", "TELNUMBER", "SALAIRE","STATUT","CATEGORIE","INDICE DE SALAIRE","OCCUPATION"};
        String[] afficher = new String[11];
        DefaultTableModel model = new DefaultTableModel(null, agent);
        try {
            MainFrmApplication.connect();
            Statement statement = MainFrmApplication.connection.createStatement();
            ResultSet resulset = statement.executeQuery("SELECT * FROM AGENT");

            while (resulset.next()) {
                afficher[0] = resulset.getString("code");
                afficher[1] = resulset.getString("nom");
                afficher[2] = resulset.getString("date_naissance");
                afficher[3] = resulset.getString("address");
                afficher[4] = resulset.getString("email");
                afficher[5] = resulset.getString("telnumber");
                afficher[6] = resulset.getString("salaire");
                afficher[7] = resulset.getString("statut");
                afficher[8] = resulset.getString("categorie");
                afficher[9] = resulset.getString("indice_salaire");
                afficher[10] = resulset.getString("occupation");
                model.addRow(afficher);
            }
            listeAgent.setModel(model);
            MainFrmApplication.connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
