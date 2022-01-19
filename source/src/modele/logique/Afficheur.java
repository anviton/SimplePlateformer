package modele.logique;

import modele.metier.Niveau;
import modele.metier.Personnage;

import java.util.List;

public abstract class Afficheur {


    public abstract void mettreAjourLAffichageDuPersonnagePrincipal(Personnage p, double ancienPositionX, double ancienPositionY);

    public abstract void afficherLeNiveau(Niveau n, List<String> cheminImagesBlocs, Personnage peso);

    public abstract void mettreAJourLAffichageDuTemps(int temps);

}
