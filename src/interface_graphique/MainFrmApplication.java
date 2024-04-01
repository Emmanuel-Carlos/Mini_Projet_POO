package interface_graphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class MainFrmApplication extends JFrame {

    public static Connection connection;
    public static PreparedStatement preparedStatement;

    public JPanel panelMain;
    private JPanel principale;
    private JPanel secondaire1;
    private JPanel secondaire2;
    private JButton ajouterContactButton;
    private JButton listeDeContactButton;
    private JButton quitterButton;

    public MainFrmApplication() {
        ajouterContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Creation_contacts creation_contacts=new Creation_contacts();
                creation_contacts.setVisible(true);

            }
        });
        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        listeDeContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Repertoire repertoire=new Repertoire();
                repertoire.setVisible(true);
                repertoire.tableEtudiant();
                repertoire.tableEnseignant();
               repertoire.tableAgent();
            }
        });
    }
    public static void main(String[] args)
    {
        MainFrmApplication test=new MainFrmApplication();
        test.setContentPane(test.panelMain);
        test.setTitle("Gestionnaire De Contacts");
        test.setSize(700,400);
        test.setVisible(true);
        test.setResizable(false);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public static void connect()
    {
        try
        {
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root","2005emma");
            System.out.println("connexion reussie");

        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
