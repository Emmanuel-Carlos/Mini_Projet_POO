package interface_graphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Creation_contacts extends JFrame {
    private JPanel principale;
    private JButton enseignantButton;
    private JButton etudiantButton;
    private JTabbedPane tabbedPane;
    private JPanel secondaire;
    private JPanel panelChoix;
    private JPanel panelAjout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel Etudiant;
    private JPanel Enseignant;
    private JPanel libelleEtudiant;
    private JTextField nomEtudiant;
    private JTextField codeEtudiant;
    private JPanel informationsEtudiant;
    private JPanel panelDeChampSaisiEtudiant;
    private JPanel panelBoutonAjouterEtudiant;
    private JButton ajouterEtudiant;
    private JButton annulerEtudiant;
    private JTextField naissanceEnseignant;
    private JTextField nomEnseignant;
    private JTextField codeEnseignant;
    private JButton ajouterEnseignant;
    private JButton annulerEnseignant;
    private JPanel agent;
    private JTextField codeAgent;
    private JButton ajouterAgent;
    private JButton annulerAgent;
    private JButton agentButton;
    private JTextField addresseEnseignant;
    private JTextField emailEnseignant;
    private JTextField telnumberEnseignant;
    private JComboBox statutEnseignant;
    private JTextField naissanceEtudiant;
    private JTextField addresseEtudiant;
    private JTextField emailEtudiant;
    private JTextField telnumberEtudiant;
    private JComboBox cycleEtudiant;
    private JTextField nomAgent;
    private JTextField naissanceAgent;
    private JTextField addresseAgent;
    private JTextField emailAgent;
    private JTextField telnumberAgent;
    private JTextField salaireAgent;
    private JTextField statutAgent;
    private JComboBox categorieAgent;
    private JTextField indiceSalaireAgent;
    private JTextField occupationAgent;
    private JPanel libelleEnseignant;
    private JPanel informationsEnseignant;
    private JPanel panelBoutonAjouterEnseignant;
    private JPanel panelChampDeSaisiEnseignant;
    private JPanel libelleAgent;
    private JPanel informationsAgent;
    private JPanel panelBoutonAjouterAgent;
    private JPanel panelChampDeSaisiAgent;
    private JTextField niveauEtudiant;


    {
        setTitle("Ajout De Contacts");
        setSize(900,700);
        setContentPane(this.principale);
        etudiantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(0);
            }
        });
        enseignantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(1);
            }
        });
        agentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(2);
            }
        });
        annulerAgent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
        annulerEnseignant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        annulerEtudiant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }


    public Creation_contacts() {
        ajouterEtudiant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrmApplication.connect();
                try {
                    MainFrmApplication.preparedStatement=MainFrmApplication.connection.prepareStatement("INSERT INTO ETUDIANT VALUES(?,?,?,?,?,?,?,?)");

                    MainFrmApplication.preparedStatement.setString(1,codeEtudiant.getText());
                    MainFrmApplication.preparedStatement.setString(2,nomEtudiant.getText());
                    MainFrmApplication.preparedStatement.setString(3,naissanceEtudiant.getText());
                    MainFrmApplication.preparedStatement.setString(4,addresseEtudiant.getText());
                    MainFrmApplication.preparedStatement.setString(5,emailEtudiant.getText());
                    MainFrmApplication.preparedStatement.setString(6,telnumberEtudiant.getText());
                    MainFrmApplication.preparedStatement.setString(7, (String) cycleEtudiant.getSelectedItem());
                    MainFrmApplication.preparedStatement.setString(8,niveauEtudiant.getText());

                    MainFrmApplication.preparedStatement.executeUpdate();
                    MainFrmApplication.connection.close();
                    JOptionPane.showMessageDialog(null,"Etudiant Enregistré");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ajouterEnseignant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainFrmApplication.connect();
                try {
                    MainFrmApplication.preparedStatement=MainFrmApplication.connection.prepareStatement("INSERT INTO ENSEIGNANT VALUES(?,?,?,?,?,?,?)");
                    MainFrmApplication.preparedStatement.setString(1,codeEnseignant.getText());
                    MainFrmApplication.preparedStatement.setString(2,nomEnseignant.getText());
                    MainFrmApplication.preparedStatement.setString(3,naissanceEnseignant.getText());
                    MainFrmApplication.preparedStatement.setString(4,addresseEnseignant.getText());
                    MainFrmApplication.preparedStatement.setString(5,emailEnseignant.getText());
                    MainFrmApplication.preparedStatement.setString(6,telnumberEnseignant.getText());
                    MainFrmApplication.preparedStatement.setString(7, (String) statutEnseignant.getSelectedItem());

                    MainFrmApplication.preparedStatement.executeUpdate();
                    MainFrmApplication.connection.close();
                    JOptionPane.showMessageDialog(null,"Enseignant Enregistré");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ajouterAgent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainFrmApplication.connect();
                try {
                    MainFrmApplication.preparedStatement=MainFrmApplication.connection.prepareStatement("INSERT INTO AGENT VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                    MainFrmApplication.preparedStatement.setString(1,codeAgent.getText());
                    MainFrmApplication.preparedStatement.setString(2,nomAgent.getText());
                    MainFrmApplication.preparedStatement.setString(3,naissanceAgent.getText());
                    MainFrmApplication.preparedStatement.setString(4,addresseAgent.getText());
                    MainFrmApplication.preparedStatement.setString(5,emailAgent.getText());
                    MainFrmApplication.preparedStatement.setString(6,telnumberAgent.getText());
                    MainFrmApplication.preparedStatement.setInt(7, Integer.parseInt(salaireAgent.getText()));
                    MainFrmApplication.preparedStatement.setString(8,statutAgent.getText());
                    MainFrmApplication.preparedStatement.setString(9, (String) categorieAgent.getSelectedItem());
                    MainFrmApplication.preparedStatement.setInt(10, Integer.parseInt(indiceSalaireAgent.getText()));
                    MainFrmApplication.preparedStatement.setString(11,occupationAgent.getText());

                    MainFrmApplication.preparedStatement.executeUpdate();
                    MainFrmApplication.connection.close();
                    JOptionPane.showMessageDialog(null,"Agent Enregistré");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
