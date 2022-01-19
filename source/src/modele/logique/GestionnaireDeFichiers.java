package modele.logique;

import modele.LesScores;
import modele.Score;

import java.io.*;


public class GestionnaireDeFichiers{

    public static LesScores lecture(String nomFichier){
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return lesScores;
    }

    public static void ecriture(LesScores lesScores, String nomFichier) throws Exception{
        FileWriter auteur = new FileWriter(nomFichier);
        BufferedWriter auteurDeScores = new BufferedWriter(auteur);
        for (Score score : lesScores.lesScoresProperty()) {
            auteurDeScores.write(score.getNom() + ",");
            auteurDeScores.write(score.getNumNiveau() + ",");
            auteurDeScores.write(score.getTemps() + "");
            auteurDeScores.newLine();
        }
        auteurDeScores.close();
    }

}
