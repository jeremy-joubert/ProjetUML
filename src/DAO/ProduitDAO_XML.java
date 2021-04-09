package DAO;

import entity.I_Produit;
import factory.ProduitFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ProduitDAO_XML {
    private String uri = "src/bdd/Produits.xml";
    private Document doc;

    public ProduitDAO_XML() {
        SAXBuilder sdoc = new SAXBuilder();
        try {
            doc = sdoc.build(uri);
        } catch (Exception e) {
            System.out.println("erreur construction arbre JDOM");
        }
    }

    public boolean creer(I_Produit p, String nom) {
        try {
            Element root = doc.getRootElement();
            Element prod = new Element("produit");
            prod.setAttribute("nom", p.getNom());
            Element prix = new Element("prixHT");
            prod.addContent(prix.setText(String.valueOf(p.getPrixUnitaireHT())));
            Element qte = new Element("quantite");
            prod.addContent(qte.setText(String.valueOf(p.getQuantite())));
            Element nomCatalogue = new Element("nomCatalogue");
            prod.addContent(nomCatalogue.setText(nom));
            root.addContent(prod);
            return sauvegarde();
        } catch (Exception e) {
            System.out.println("erreur creer produit");
            return false;
        }
    }

    public boolean maj(I_Produit p, String nomCatalogue) {
        try {
            Element prod = chercheProduit(p.getNom(), nomCatalogue);
            if (prod != null) {
                prod.getChild("quantite").setText(String.valueOf(p.getQuantite()));
                return sauvegarde();
            }
            return false;
        } catch (Exception e) {
            System.out.println("erreur maj produit");
            return false;
        }
    }

    public boolean supprimer(I_Produit p, String nomCatalogue) {
        try {
            Element root = doc.getRootElement();
            Element prod = chercheProduit(p.getNom(), nomCatalogue);
            if (prod != null) {
                root.removeContent(prod);
                return sauvegarde();
            } else
                return false;
        } catch (Exception e) {
            System.out.println("erreur supprimer produit");
            return false;
        }
    }

    public I_Produit lire(String nom, String nomCatalogue) {
        Element e = chercheProduit(nom, nomCatalogue);
        if (e != null) {
            try {
                return ProduitFactory.creerProduit(e.getAttributeValue("nom"), Double.parseDouble(e.getChildText("prixHT")), Integer.parseInt(e.getChildText("quantite")));
            } catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }
        else
            return null;
    }

    public List<I_Produit> lireTous(String nomCatalogue) {
        List<I_Produit> l = new ArrayList<>();
        List<Element> lProd = chercherProduits(nomCatalogue);
        if(lProd==null){
            return l;
        }
        for (Element prod : lProd) {
            String nomP = prod.getAttributeValue("nom");
            Double prix = Double.parseDouble(prod.getChild("prixHT").getText());
            int qte = Integer.parseInt(prod.getChild("quantite").getText());
            l.add(ProduitFactory.creerProduit(nomP, prix, qte));
        }

        return l;
    }

    private boolean sauvegarde() {
        System.out.println("Sauvegarde");
        XMLOutputter out = new XMLOutputter();
        try {
            out.output(doc, new PrintWriter(uri));
            return true;
        } catch (Exception e) {
            System.out.println("erreur sauvegarde dans fichier XML");
            return false;
        }
    }

    private Element chercheProduit(String nom, String nomCatalogue) {
        Element root = doc.getRootElement();
        List<Element> lProd = root.getChildren("produit");
        int i = 0;
        while (i < lProd.size() && !lProd.get(i).getAttributeValue("nom").equals(nom) && !lProd.get(i).getChildText("nomCatalogue").equals(nomCatalogue))
            i++;
        if (i < lProd.size()) {
            return lProd.get(i);
        }else
            return null;
    }

    private List<Element> chercherProduits(String nomCatalogue){
        try {
            Element root = doc.getRootElement();
            List<Element> lProd = root.getChildren("produit");
            List<Element> listProduits=new ArrayList<>();
            for(Element element : lProd){
                if (element.getChildText("nomCatalogue").equals(nomCatalogue)){
                    listProduits.add(element);
                }
            }
            return listProduits;
        }catch (Exception e) {
            System.out.println("erreur cherhcer tous les produits");
        }
        return null;
    }
}
