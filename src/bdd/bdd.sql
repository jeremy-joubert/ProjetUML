CREATE OR REPLACE TABLE Produits(
    numProduit NUMBER,nomProduit VARCHAR(25),quantiteStock NUMBER,prixProduit INTEGER, numCatalogue NUMBER,
    CONSTRAINT pk_numProduit PRIMARY KEY (numProduit),
    CONSTRAINT fk_numCatalogue_Catalogue FOREIGN KEY (numCatalogue) REFERENCES Catalogue(numCatalogue));
    CONSTRAINT ck_nomProduit UNIQUE (nomProduit),
    CONSTRAINT ck_prix  CHECK (prixProduit > 0),
    CONSTRAINT  ck_quantite CHECK (quantiteStock >= 0)
);

CREATE OR REPLACE SEQUENCE sq_produit START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE procedure_add_produit
(p_nomProduit Produits.nomProduit%TYPE, p_quantiteStock Produits.quantiteStock%TYPE, p_prixProduit Produits.prixProduit%TYPE, p_numCatalogue Catalogue.numCatalogue%TYPE )AS
    v_nomProduit NUMBER;
BEGIN
    SELECT count(*) INTO v_nomProduit
    FROM Produits
    WHERE nomProduit=p_nomProduit AND numCatalogue=p_numCatalogue;
    IF v_nomProduit = 1 THEN
        RAISE_APPLICATION_ERROR (-20001, 'Ce produit est déja dans le catalogue!');
	END IF;
    INSERT INTO Produits(numProduit ,nomProduit ,quantiteStock ,prixProduit, numCatalogue)
    VALUES (sq_produit.NEXTVAL, p_nomProduit, p_quantiteStock, p_prixProduit, p_numCatalogue);
END;

CREATE OR REPLACE TABLE Catalogue(
    numCatalogue NUMBER,nomCatalogue VARCHAR(25),
    CONSTRAINT pk_numCatalogue PRIMARY KEY (numCatalogue),
    CONSTRAINT ck_nomCatalogue UNIQUE (nomCatalogue)
);

CREATE OR REPLACE SEQUENCE sq_catalogue START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE procedure_create_catalogue
(p_nomCatalogue Catalogue.nomCatalogue%TYPE)AS
BEGIN
    INSERT INTO Catalogue(numCatalogue, nomCatalogue)
    VALUES (sq_catalogue.NEXTVAL, p_nomCatalogue);
END;
