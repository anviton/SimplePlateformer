package modele.logique;

import modele.LesScores;
import modele.Score;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Classe ChargeurDeScores permet de charger les scores
 */
public class ChargeurDeScores {

    /**
     * Permet de charger les scores
     * @param nomFichier nom du fichier ou sont enregistrés des scores
     * @return les scores chargés
     */
    public LesScores charger(String nomFichier){
        LesScores lesScores = new LesScores();
        try {
            FileReader lecteur = new FileReader(nomFichier);
            BufferedReader lecteurDeScore = new BufferedReader(lecteur);
            String ligne;
            String elementDeSeparation = ",";
            while ((ligne = lecteurDeScore.readLine()) != null) {
                String[] unScore = ligne.split(elementDeSeparation);
                lesScores.ajouterScores(new Score(Integer.parseInt(unScore[2]), unScore[0], Integer.parseInt(unScore[1])));
            }
            lecteurDeScore.close();
            lecteur.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lesScores;
    }
}
