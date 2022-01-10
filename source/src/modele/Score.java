package modele;

import java.io.Serializable;

public class Score implements Serializable {
    private final int temps;
    private final String nom;
    private final int numNiveau;


    public Score(int temps, String nom, int numNiveau) {
        this.temps = temps;
        this.nom = nom;
        this.numNiveau = numNiveau;
    }

    public int getTemps() {
        return temps;
    }

    public String getNom() {
        return nom;
    }

    public int getNumNiveau() {
        return numNiveau;
    }

}
