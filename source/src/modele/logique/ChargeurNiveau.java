package modele.logique;

import modele.metier.Bloc;
import modele.metier.HitBox;
import modele.metier.Niveau;

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
            /*String cheminTest = String.valueOf(getClass().getResource(chemin));
            System.out.println(cheminTest);
            File f =new File(cheminTest);
            System.out.println(f);*/
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
                    if (type == 1 || type == 2) {
                        listeDeBlocs.add(new Bloc(type, i, j, new HitBox(50,50)));
                    }
                    else {
                        listeDeBlocs.add(new Bloc(type, i, j, null));
                    }
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
