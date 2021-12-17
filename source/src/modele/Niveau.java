package modele;

import java.util.List;

public class Niveau {
    int difficulte;
    List<Bloc> listeBlocs;


    public Niveau(List<Bloc> listeBlocs) {
        this.listeBlocs = listeBlocs;
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
}
