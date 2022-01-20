package modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classes regroupant les listes observables pour pouvoir recupérer la liste de score correctement
 */

public class LesScores {
    private ObservableList<Score> lesScoresObs = FXCollections.observableArrayList();
    private final ListProperty<Score> lesScores = new SimpleListProperty<>(lesScoresObs);
    public ObservableList<Score> getLesScores() {return lesScores.get();}
    public void setLesScores(ObservableList<Score> value) {lesScores.set(value);}
    public ListProperty<Score> lesScoresProperty() {return lesScores;}

    public LesScores() {

    }

    /**
     * ajouterScores permet d'ajouter un score a la liste déja existante
     * @param score score a jouter a la liste
     */

    public void ajouterScores(Score score){
        lesScoresObs.add(score);
    }

    /**
     * trierLesScores permet de trier les scores de la liste
     */

    public void trierLesScores(){
        lesScores.sort(null);
    }
}
