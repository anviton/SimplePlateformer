package modele;

import java.util.ArrayList;
import java.util.List;

public class ChargeurNiveau {
    List<String> ListeCheminImgBloc;


    public ChargeurNiveau(List<String> ListeCheminImgBloc) {
        this.ListeCheminImgBloc = ListeCheminImgBloc;
    }

    public Niveau chargerNiveau(String chemin){
        Niveau n;
        List<BlocAffichable> listeDeBlocs = new ArrayList<>();
        n = new Niveau(listeDeBlocs);
        return n;
    }

}
