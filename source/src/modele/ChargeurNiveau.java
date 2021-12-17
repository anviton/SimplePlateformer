package modele;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChargeurNiveau {
    List<String> listeCheminImgBloc;


    public ChargeurNiveau(List<String> ListeCheminImgBloc) {
        this.listeCheminImgBloc = ListeCheminImgBloc;
    }

    public Niveau chargerNiveau(String chemin){
        Niveau n;
        List<Bloc> listeDeBlocs = new ArrayList<>();
        n = new Niveau(listeDeBlocs);
        int i = 0, j = 0;
        String elementDeSeparation = ",";
        String[] listeDeTuiles;
        try {
            FileReader lecteur = new FileReader(chemin);
            BufferedReader lecteurDeTuile = new BufferedReader(lecteur);
            String ligne;
            while ((ligne = lecteurDeTuile.readLine()) != null){
                String[] tabTuiles = ligne.split(elementDeSeparation);
                for (String tuile : tabTuiles){
                    //System.out.println("Bloc id : " + tuile + "positions x : " + i + " position y : " + j );
                    int type = Integer.parseInt(tuile);
                    listeDeBlocs.add(new Bloc(type, i, j));
                    i++;
                }
                i = 0;
                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        n = new Niveau(listeDeBlocs);
        return n;
    }

}
