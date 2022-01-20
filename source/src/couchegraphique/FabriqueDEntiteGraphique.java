package couchegraphique;

import modele.metier.Composant;
import modele.metier.Entite;

/**
 * FabriqueDEntiteGraphique fabrique des entités graphique a partir de la fabrique de produit graphique
 */

public class FabriqueDEntiteGraphique extends FabriqueDeProduitGraphique{

    /**
     * fabrique un produit graphique
     * @param composant composant a créer
     * @param cheminImg image du composant
     * @return le composant
     */

    @Override
    public ProduitGraphique fabrique(Composant composant, String cheminImg){
        return new EntiteGraphique((Entite)composant, cheminImg);
    }

}
