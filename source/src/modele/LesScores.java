package modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Classe LesScores stocke les scores
 * @author anviton khloichet
 */
public class LesScores {
    private ObservableList<Score> lesScoresObs = FXCollections.observableArrayList();
    private final ListProperty<Score> lesScores = new SimpleListProperty<>(lesScoresObs);
    public ObservableList<Score> getLesScores() {return lesScores.get();}
    public void setLesScores(ObservableList<Score> value) {lesScores.set(value);}
    public ListProperty<Score> lesScoresProperty() {return lesScores;}

    /**
     * Ajoute un score à la liste des scores
     * @param score score à ajouter à la liste
     */
    public void ajouterScore(Score score){
        lesScores.add(score);
    }

    /**
     * Trie la liste des scores
     */
    public void trierLesScores(){
        lesScores.sort(null);
    }
}
