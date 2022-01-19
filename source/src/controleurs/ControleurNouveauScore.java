package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import modele.logique.GestionnaireDeFichiers;
import modele.Score;
import modele.LesScores;

import java.io.IOException;

public class ControleurNouveauScore {
    @FXML
    private TextField textField;
    @FXML
    private Label labelScore;

    private final Score score ;//= new Score(20, "t", 1);
    private LesScores lesScores;

    public ControleurNouveauScore(LesScores lesScores, Score score) {
        this.score = score;
        this.lesScores = lesScores;
    }

    public void initialize() {
        StringConverter<Integer> converter = new IntegerStringConverter();
        textField.textProperty().bindBidirectional(score.nomProperty());
        labelScore.textProperty().bindBidirectional(score.tempsProperty(), converter);
    }


    public void valideScore(ActionEvent bouttonValider) {
        Button b = (Button)bouttonValider.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        GridPane a;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/menu.fxml"));
        lesScores.ajouterScores(score);
        lesScores.trierLesScores();
        try {
            GestionnaireDeFichiers.ecriture(lesScores, "resources/score/score.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        fxmlLoader.setController(new ControleurMenu(lesScores));
        try {
            a = fxmlLoader.load();
            Scene s = new Scene(a, 1000, 1000);
            s.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
            stage.setTitle("Menu Principal");
            stage.setScene(s);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
