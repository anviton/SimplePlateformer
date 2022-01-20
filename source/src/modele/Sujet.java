package modele;

import controleurs.ControleurObservateur;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujet implements Runnable{
    private final List<ControleurObservateur> observateurs;

    public Sujet() {
        this.observateurs = new ArrayList<>();
    }

    /**
     * Notifie les ControleurObservateurs
     */
    public void nottifier(){
        for(ControleurObservateur o : observateurs){
            o.mettreAJour();
        }
    }

    /**
     * Attache un observateur
     * @param observateur l'observateur à attacher
     */
    public void attacher(ControleurObservateur observateur){
        observateurs.add(observateur);
    }

    /**
     * Détache un observateur
     * @param observateur l'observateur à détacher
     */
    public void detacher(ControleurObservateur observateur){
        observateurs.remove(observateur);
    }
}
