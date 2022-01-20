package couchegraphique;

import modele.metier.Composant;

/**
 * FabriqueDeProduitGraphique fabrique des produits graphique
 */

public abstract class FabriqueDeProduitGraphique {
    public ProduitGraphique produit;

    /**
     * fabrique Fabrique un produit graphique
     * @param composant composant a fabriquer
     * @param chemingImg image du composant
     * @return le composant
     */

    public abstract ProduitGraphique fabrique(Composant composant, String chemingImg);

    /**
     * operation
     * @param composant
     * @param cheminImg
     */

    public void operation(Composant composant, String cheminImg){
        produit = fabrique(composant, cheminImg);
    }
}
