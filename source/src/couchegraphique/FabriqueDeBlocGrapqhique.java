package couchegraphique;

import modele.Bloc;
import modele.Composant;

public class FabriqueDeBlocGrapqhique extends FabriqueDeProduitGraphique{

    @Override
    public ProduitGraphique fabrique(Composant composant, String cheminImg){
        return new BlocGraphique((Bloc)composant, cheminImg);
    }
}
