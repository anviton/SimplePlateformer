package controleurs;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import modele.GestionnaireDeFichiers;
import modele.Score;
import modele.metier.LesScores;

public class ControleurNouveauScore {
    @FXML
    private TextField textField;
    @FXML
    private Label labelScore;

    private final Score score ;//= new Score(20, "t", 1);

    public ControleurNouveauScore(Score score) {
        this.score = score;
    }

    public void initialize() {
        //StringProperty st = new SimpleStringProperty();
        StringConverter<Integer> converter = new IntegerStringConverter();
        textField.textProperty().bindBidirectional(score.nomProperty());
        labelScore.textProperty().bindBidirectional(score.tempsProperty(), converter);
    }


    public void valideScore(ActionEvent actionEvent) {
        LesScores lesScores = null;
        try {
            lesScores = GestionnaireDeFichiers.lecture("resources/score/score.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        lesScores.ajouterScores(score);
        try {
            GestionnaireDeFichiers.ecriture(lesScores, "resources/score/score.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
