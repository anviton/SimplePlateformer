package modele.logique;

import modele.LesScores;
import modele.Score;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Classe SauveurDeScores permet la sauvegarde des scores
 * @author anviton khloichet
 */
public class SauveurDeScores {

    /**
     * Sauvegarde les scores
     * @param lesScores scores à sauvegarder
     * @param nomFichier chemin du fichier dans lequel les scores vont être sauvegardés
     */
    public void sauver(LesScores lesScores, String nomFichier){
        try {
            FileWriter auteur = new FileWriter(nomFichier);
            BufferedWriter auteurDeScores = new BufferedWriter(auteur);
            for (Score score : lesScores.lesScoresProperty()) {
                auteurDeScores.write(score.getNom() + ",");
                auteurDeScores.write(score.getNumNiveau() + ",");
                auteurDeScores.write(score.getTemps() + "");
                auteurDeScores.newLine();
            }
            auteurDeScores.close();
            auteur.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
