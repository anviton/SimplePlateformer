package modele;

import java.util.List;

public abstract class Afficheur {
    private ObjetGraphique observateur;
    private Jeu afficheur;


    public abstract void mettreAjourLAffichageDuPersonnagePrincipal(Personnage p, double ancienPositionX, double ancienPositionY);

    public abstract void afficherLeNiveau(Niveau n, List<String> cheminImagesBlocs, Personnage peso);

    public abstract void mettreAJourLAffichageDuTemps(int temps);

}
