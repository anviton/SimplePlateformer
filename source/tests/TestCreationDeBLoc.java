import modele.*;

import java.util.ArrayList;
import java.util.List;

public class TestCreationDeBLoc {
    public static void main(String[] args){
        //Bloc blocTest = new Bloc(1, 0,0);
        //System.out.println(blocTest);
        List<String> listeCheminImageBloc = new ArrayList<String>();
        listeCheminImageBloc.add("blocs/briqueBase.png");
        listeCheminImageBloc.add("/personnage.png");
        ChargeurNiveau chargeur =  new ChargeurNiveau();
        String cheminACharger = "resources/Niveaux/niveau1";
        Niveau n = chargeur.chargerNiveau(cheminACharger);
        System.out.println(n.getListeBlocs());
    }
}
