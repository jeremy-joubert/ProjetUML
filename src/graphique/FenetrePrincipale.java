package graphique;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class FenetrePrincipale extends JFrame implements ActionListener,
        WindowListener {

    private JButton btAfficher;
    private JButton btNouveauProduit;
    private JButton btSupprimerProduit;
    //	private JButton btNouvelleCategorie;
//	private JButton btSupprimerCategorie;
    private JButton btAchat;
    private JButton btVente;
    private JButton btQuitter;
    private Controller controller;


    public FenetrePrincipale(Controller controller) {

        this.controller=controller;
        setTitle("exercice Produits");
        setBounds(500, 500, 320, 250);
        JPanel panAffichage = new JPanel();
        JPanel panNouveauSupprimerProduit = new JPanel();
//		JPanel panNouveauSupprimerCategorie = new JPanel();
        JPanel panAchatVente = new JPanel();
        JPanel panQuitter = new JPanel();
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        btAfficher = new JButton("Quantités en stock");
        btNouveauProduit = new JButton("Nouveau Produit");
        btSupprimerProduit = new JButton("Supprimer Produit");
//		btNouvelleCategorie = new JButton("Nouvelle Categorie");
//		btSupprimerCategorie = new JButton("Supprimer Categorie");
        btAchat = new JButton("Achat Produits");
        btVente = new JButton("Vente Produits");
        btQuitter = new JButton("Quitter");
        panAffichage.add(btAfficher);
        panNouveauSupprimerProduit.add(btNouveauProduit);
        panNouveauSupprimerProduit.add(btSupprimerProduit);
//		panNouveauSupprimerCategorie.add(btNouvelleCategorie);
//		panNouveauSupprimerCategorie.add(btSupprimerCategorie);
        panAchatVente.add(btAchat);
        panAchatVente.add(btVente);
        panQuitter.add(btQuitter);

        contentPane.add(panAffichage);
//		contentPane.add(panNouveauSupprimerCategorie);
        contentPane.add(panNouveauSupprimerProduit);
        contentPane.add(panAchatVente);
        contentPane.add(panQuitter);

        btAfficher.addActionListener(this);
        btNouveauProduit.addActionListener(this);
        btSupprimerProduit.addActionListener(this);
//		btNouvelleCategorie.addActionListener(this);
//		btSupprimerCategorie.addActionListener(this);
        btAchat.addActionListener(this);
        btVente.addActionListener(this);
        btQuitter.addActionListener(this);

        addWindowListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

/* tabProduits permet de tester le fonctionnement des fenêtres avec un tableau de noms de produits "en dur"
   Quand l'application fonctionnera, il faudra bien sûr récupérer les noms des produits dans le Catalogue */
        String[] tabProduits = controller.getNomProduits();
        /* Même chose pour tabCategories (partie 4) */
//		String[] tabCategories = new String[] {"Bio", "Luxe" };

        if (e.getSource() == btAfficher)
            new FenetreAffichage(controller.getInfoEtatStocksController().toString());
        if (e.getSource() == btNouveauProduit)
//			new FenetreNouveauProduit(tabCategories);
            new FenetreNouveauProduit(controller.getEditerProduitController());
        if (e.getSource() == btSupprimerProduit)
            new FenetreSuppressionProduit(tabProduits, controller.getEditerProduitController());
//		if (e.getSource() == btNouvelleCategorie)
//			new FenetreNouvelleCategorie();
//		if (e.getSource() == btSupprimerCategorie)
//			new FenetreSuppressionCategorie(tabCategories);
        if (e.getSource() == btAchat)
            new FenetreAchat(tabProduits, controller.getNewAchatVenteController());
        if (e.getSource() == btVente)
            new FenetreVente(tabProduits, controller.getNewAchatVenteController());
        if (e.getSource() == btQuitter){
            System.out.println("Au revoir");
            System.exit(0);
        }
    }

    public void windowClosing(WindowEvent arg0) {
        System.out.println("Au revoir");
        System.exit(0);
    }

    public void windowActivated(WindowEvent arg0) {}
    public void windowClosed(WindowEvent arg0) {}
    public void windowDeactivated(WindowEvent arg0) {}
    public void windowDeiconified(WindowEvent arg0) {}
    public void windowIconified(WindowEvent arg0) {}
    public void windowOpened(WindowEvent arg0) {}



}

