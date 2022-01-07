package modele;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChargeurNiveau {

    public Niveau chargerNiveau(String chemin){
        Niveau n;
        List<Bloc> listeDeBlocs = new ArrayList<>();
        List<Integer> listePositions = new ArrayList<>();
        int i = 0, j = 0;
        String elementDeSeparation = ",";
        String cheminFond = null;
        try {
            FileReader lecteur = new FileReader(chemin);
            BufferedReader lecteurDeTuile = new BufferedReader(lecteur);
            String ligne;
            cheminFond = lecteurDeTuile.readLine();

            String[] positions = lecteurDeTuile.readLine().split(elementDeSeparation);
            for (String pos : positions){
                listePositions.add(Integer.parseInt(pos));
            }

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
        n = new Niveau(listePositions, cheminFond, listeDeBlocs);
        if (!listeDeBlocs.isEmpty()) {
            Bloc bloc = listeDeBlocs.get(listeDeBlocs.size() - 1);
            n.setHauteurNiveau(bloc.getPositionY());
            n.setLargeurNiveau(bloc.getPositionX());
        }
        return n;
    }

}
