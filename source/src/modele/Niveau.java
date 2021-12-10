package modele;

import java.util.List;

public class Niveau {
    int difficulte;
    List<BlocAffichable> listeBlocAffichable;


    public Niveau(List<BlocAffichable> listeBlocAffichable) {
        this.listeBlocAffichable = listeBlocAffichable;
        difficulte = 1;
    }

    public List<BlocAffichable> getListeBlocAffichable() {
        return listeBlocAffichable;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
}
