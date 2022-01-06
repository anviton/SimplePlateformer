package modele;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChargeurNiveau {

    public Niveau chargerNiveau(String chemin){
        Niveau n;
        List<Bloc> listeDeBlocs = new ArrayList<>();
        int i = 0, j = 0;
        String elementDeSeparation = ",";
        String cheminFond = null;
        try {
            FileReader lecteur = new FileReader(chemin);
            BufferedReader lecteurDeTuile = new BufferedReader(lecteur);
            String ligne;
            cheminFond = lecteurDeTuile.readLine();
            while ((ligne = lecteurDeTuile.readLine()) != null){
                String[] tabTuiles = ligne.split(elementDeSeparation);
                for (String tuile : tabTuiles){
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
        n = new Niveau(listeDeBlocs, cheminFond);
        if (!listeDeBlocs.isEmpty()) {
            Bloc bloc = listeDeBlocs.get(listeDeBlocs.size() - 1);
            n.setHauteur(bloc.getPositionY());
            n.setLargeur(bloc.getPositionX());
        }
        return n;
    }

}
