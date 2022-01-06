package modele;

import java.util.List;

public class Niveau {
    int difficulte;
    private int hauteur;
    private int largeur;
    private String cheminFond;
    List<Bloc> listeBlocs;


    public Niveau(List<Bloc> listeBlocs, String cheminFond) {
        this.listeBlocs = listeBlocs;
        this.cheminFond = cheminFond;
        difficulte = 1;
    }

    public List<Bloc> getListeBlocAffichable() {
        return listeBlocs;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public String getCheminFond() {
        return cheminFond;
    }

    private void setCheminFond(String cheminFond) {
        this.cheminFond = cheminFond;
    }
}
