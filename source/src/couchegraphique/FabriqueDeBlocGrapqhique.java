package couchegraphique;

import modele.metier.Bloc;
import modele.metier.Composant;

public class FabriqueDeBlocGrapqhique extends FabriqueDeProduitGraphique{

    @Override
    public ProduitGraphique fabrique(Composant composant, String cheminImg){
        return new BlocGraphique((Bloc)composant, cheminImg);
    }
}
