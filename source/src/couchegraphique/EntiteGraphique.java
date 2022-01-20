package couchegraphique;

import modele.metier.Entite;

/**
 * EntiteGraphique
 */

public class EntiteGraphique extends ProduitGraphique{
    private final Entite entite;

    /**
     * EntiteGraphique constructeur d'une entité graphique
     * @param entite entité a associer a l'image
     * @param cheminImg chemin de l'image pour l'entité
     */

    public EntiteGraphique(Entite entite, String cheminImg) {
        super(cheminImg);
        this.entite = entite;
    }

    /**
     * getEntite attrape une entité
     * @return une entité
     */

    public Entite getEntite() {
        return entite;
    }

    /**
     * toString ecrit une entité pour les test
     * @return le chemin de l'entité pour les tests
     */

    @Override
    public String toString() {
        return "EntiteGrpahique{" +
                "img='" + image + '\'' +
                ", entité=" + entite +
                '}';
    }
}
