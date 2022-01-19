package modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class LesScores {
    private ObservableList<Score> lesScoresObs = FXCollections.observableArrayList();
    private final ListProperty<Score> lesScores = new SimpleListProperty<>(lesScoresObs);
    public ObservableList<Score> getLesScores() {return lesScores.get();}
    public void setLesScores(ObservableList<Score> value) {lesScores.set(value);}
    public ListProperty<Score> lesScoresProperty() {return lesScores;}

    public LesScores() {

    }

    public void ajouterScores(Score score){
        lesScoresObs.add(score);
    }
    public void trierLesScores(){
        lesScores.sort(null);
    }
}
