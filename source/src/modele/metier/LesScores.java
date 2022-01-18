package modele.metier;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.Score;


public class LesScores {
    private final ObservableList<Score> lesScoresObs = FXCollections.observableArrayList();
    private final ListProperty<Score> lesScores = new SimpleListProperty<>(lesScoresObs);
    public ObservableList<Score> getLesScores() {return lesScores.get();}
    public void setLesScores(ObservableList<Score> value) {lesScores.set(value);}
    public ListProperty<Score> lesScoresProperty() {return lesScores;}

    public LesScores() {

    }

    public void ajouterScores(Score score){
        lesScoresObs.add(score);
    }
}
