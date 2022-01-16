package couchegraphique;

import modele.metier.Composant;
import modele.metier.Entite;

public class FabriqueDEntiteGraphique extends FabriqueDeProduitGraphique{

    @Override
    public ProduitGraphique fabrique(Composant composant, String cheminImg){
        return new EntiteGraphique((Entite)composant, cheminImg);
    }

}
