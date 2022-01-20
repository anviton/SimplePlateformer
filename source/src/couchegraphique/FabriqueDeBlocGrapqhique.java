package couchegraphique;

import modele.metier.Bloc;
import modele.metier.Composant;

/**
 * FabriqueDeBlocGrapqhique fabrique des objets graphique a partir de la fabrique de produit graphique
 */

public class FabriqueDeBlocGrapqhique extends FabriqueDeProduitGraphique{

    /**
     * fabrique un poroduit graphique
     * @param composant composant a créer
     * @param cheminImg image du composant
     * @return un composant
     */

    @Override
    public ProduitGraphique fabrique(Composant composant, String cheminImg){
        return new BlocGraphique((Bloc)composant, cheminImg);
    }
}
