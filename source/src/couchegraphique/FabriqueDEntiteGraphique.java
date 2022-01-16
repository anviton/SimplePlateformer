package couchegraphique;

import modele.Composant;
import modele.Entite;

public class FabriqueDEntiteGraphique extends FabriqueDeProduitGraphique{

    @Override
    public ProduitGraphique fabrique(Composant composant, String cheminImg){
        return new EntiteGraphique((Entite)composant, cheminImg);
    }

}
