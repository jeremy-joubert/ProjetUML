package DAO;

import entity.I_Catalogue;
import entity.I_Produit;
import factory.CatalogueFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CatalogueDAO_XML implements CatalogueDAO {
    private String uri = "src/bdd/Catalogue.xml";
    private Document doc;

    public CatalogueDAO_XML(){
        SAXBuilder sdoc = new SAXBuilder();
        try {
            doc = sdoc.build(uri);
        } catch (Exception e) {
            System.out.println("erreur construction arbre JDOM");
        }
    }

    @Override
    public boolean create(String nomCatalogue) {
        try {
            Element root = doc.getRootElement();
            Element prod = new Element("catalogue");
            prod.setAttribute("nomCatalogue", nomCatalogue);
            root.addContent(prod);
            return sauvegarde();
        } catch (Exception e) {
            System.out.println("erreur creer produit");
            return false;
        }
    }

    @Override
    public List read() {
        List<I_Catalogue> l = new ArrayList<>();
        try {
            Element root = doc.getRootElement();
            List<Element> lProd = root.getChildren("catalogue");

            for (Element prod : lProd) {
                String nomCatalogue = prod.getAttributeValue("nomCatalogue");
                l.add(CatalogueFactory.creerCatalogue(nomCatalogue));
            }
        } catch (Exception e) {
            System.out.println("erreur lireTous tous les Catalogues");
        }
        return l;
    }

    @Override
    public boolean updateAddProduit(I_Produit produit) {
        return false;
    }

    @Override
    public void delete(String nomCatalogue) {
        try {
            Element root = doc.getRootElement();
            Element prod = chercheCatalogue(nomCatalogue);
            if (prod != null) {
                root.removeContent(prod);
                sauvegarde();
            }
        } catch (Exception e) {
            System.out.println("erreur supprimer produit");
        }
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

    private Element chercheCatalogue(String nom) {
        Element root = doc.getRootElement();
        List<Element> lProd = root.getChildren("catalogue");
        int i = 0;
        while (i < lProd.size() && !lProd.get(i).getAttributeValue("nomCatalogue").equals(nom))
            i++;
        if (i < lProd.size())
            return lProd.get(i);
        else
            return null;
    }
}
