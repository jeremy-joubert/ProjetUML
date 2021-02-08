package entity;

public class Produit implements I_Produit {
    private int quantiteStock;
    private String nom;
    private double prixUnitaireHT;
    private double tauxTVA;

    public Produit(String nom, double prixUnitaireHT, int quantiteStock) {
        this.quantiteStock = quantiteStock;
        this.nom = nom;
        this.prixUnitaireHT = prixUnitaireHT;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "quantiteStock=" + quantiteStock +
                ", nom='" + nom + '\'' +
                ", prixUnitaireHT=" + prixUnitaireHT +
                ", tauxTVA=" + tauxTVA +
                '}';
    }

    @Override
    public boolean ajouter(int qteAchetee) {
        quantiteStock=quantiteStock+qteAchetee;
        return true;
    }

    @Override
    public boolean enlever(int qteVendue) {
        quantiteStock=quantiteStock-qteVendue;
        return true;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getQuantite() {
        return quantiteStock;
    }

    @Override
    public double getPrixUnitaireHT() {
        return prixUnitaireHT;
    }

    @Override
    public double getPrixUnitaireTTC() {
        return prixUnitaireHT*tauxTVA;
    }

    @Override
    public double getPrixStockTTC() {
        return prixUnitaireHT*tauxTVA*quantiteStock;
    }
}
