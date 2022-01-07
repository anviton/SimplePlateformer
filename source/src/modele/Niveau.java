package modele;

import java.util.List;

public class Niveau {
    private int difficulte;
    private int positionXArrivee;
    private int positionYArrivee;
    private int positionXDepart;
    private int positionYDepart;
    private int hauteurNiveau;
    private int largeurNiveau;
    private String cheminFond;
    private final List<Bloc> listeBlocs;


    public Niveau(List<Bloc> listeBlocs, String cheminFond) {
        this.listeBlocs = listeBlocs;
        this.cheminFond = cheminFond;
        positionXArrivee =
        difficulte = 1;
    }

    public List<Bloc> getListeBlocs() {
        return listeBlocs;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public int getHauteurNiveau() {
        return hauteurNiveau;
    }

    public void setHauteurNiveau(int hauteurNiveau) {
        this.hauteurNiveau = hauteurNiveau;
    }

    public int getLargeurNiveau() {
        return largeurNiveau;
    }

    public void setLargeurNiveau(int largeurNiveau) {
        this.largeurNiveau = largeurNiveau;
    }

    public String getCheminFond() {
        return cheminFond;
    }

    private void setCheminFond(String cheminFond) {
        this.cheminFond = cheminFond;
    }
}
