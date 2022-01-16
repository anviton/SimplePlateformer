import modele.logique.ChargeurNiveau;
import modele.metier.Niveau;

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
        String cheminACharger = "resources/niveaux/niveau1.niv";
        Niveau n = chargeur.chargerNiveau(cheminACharger);

        System.out.println(n.getListeBlocs());
        System.out.println("Position x de départ " + n.getPositionXDepart());
        System.out.println("Position x de départ " + n.getPositionYDepart());
        System.out.println("Position x de l'arrivée " + n.getPositionXArrivee());
        System.out.println("Position y de l'arrivée " + n.getPositionYArrivee());
    }
}
