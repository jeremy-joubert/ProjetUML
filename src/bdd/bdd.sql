CREATE TABLE Produits(
    numProduit NUMBER,nomProduit VARCHAR(25),quantiteStock NUMBER,prixProduit INTEGER,
    CONSTRAINT pk_numProduit PRIMARY KEY (numProduit),
    CONSTRAINT ck_nomProduit UNIQUE (nomProduit),
    CONSTRAINT ck_prix  CHECK (prixProduit > 0),
    CONSTRAINT  ck_quantite CHECK (quantiteStock >= 0)
);

CREATE SEQUENCE sq_produit START WITH 1 INCREMENT BY 1;

CREATE PROCEDURE procedure_add_produit(nomProduit Produits.nomProduit%TYPE, quantiteStock Produits.quantiteStock%TYPE, prixProduit Produits.prixProduit%TYPE )AS
BEGIN
    INSERT INTO Produits(numProduit ,nomProduit ,quantiteStock ,prixProduit)
    VALUES (sq_produit.NEXTVAL, nomProduit, quantiteStock, prixProduit);
END;

