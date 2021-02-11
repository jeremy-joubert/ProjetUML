package graphique;

import controller.NewAchatVenteController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreVente extends JFrame implements ActionListener {

    private JButton btVente;
    private JTextField txtQuantite;
    private JComboBox<String> combo;
    private NewAchatVenteController controller;

    public FenetreVente(String[] lesProduits, NewAchatVenteController controller) {
        this.controller=controller;
        setTitle("Vente");
        setBounds(500, 500, 200, 125);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        btVente = new JButton("Vente");
        txtQuantite = new JTextField(5);
        txtQuantite.setText("0");

        combo = new JComboBox<String>(lesProduits);
        combo.setPreferredSize(new Dimension(100, 20));
        contentPane.add(new JLabel("Produit"));
        contentPane.add(combo);
        contentPane.add(new JLabel("Quantité vendue"));
        contentPane.add(txtQuantite);
        contentPane.add(btVente);

        btVente.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        this.dispose();
        controller.newVente(combo.getSelectedItem().toString(), Integer.parseInt(txtQuantite.getText()));
    }

}
