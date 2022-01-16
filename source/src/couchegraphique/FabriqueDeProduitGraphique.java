package couchegraphique;

import modele.Composant;

public abstract class FabriqueDeProduitGraphique {
    public ProduitGraphique produit;

    public abstract ProduitGraphique fabrique(Composant composant, String chemingImg);

    public void operation(Composant composant, String cheminImg){
        produit = fabrique(composant, cheminImg);
    }
}
