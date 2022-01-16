package modele.metier;

import modele.metier.Bloc;

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
        difficulte = 1;
    }

    public Niveau(List<Integer> positions,
                  String cheminFond, List<Bloc> listeBlocs) {
        this.positionXDepart = positions.get(0);
        this.positionYDepart = positions.get(1);
        this.positionXArrivee = positions.get(2);
        this.positionYArrivee = positions.get(3);
        this.cheminFond = cheminFond;
        this.listeBlocs = listeBlocs;
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

    public int getPositionXArrivee() {
        return positionXArrivee;
    }

    public int getPositionYArrivee() {
        return positionYArrivee;
    }

    public int getPositionXDepart() {
        return positionXDepart;
    }

    public int getPositionYDepart() {
        return positionYDepart;
    }
}
