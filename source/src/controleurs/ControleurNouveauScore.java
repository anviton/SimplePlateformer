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
import modele.Score;
import modele.LesScores;
import modele.logique.SauveurDeScores;

import java.util.Objects;


/**
 * Controleur qui permet de gérer la vue permettant d'enregistrer un nouveau score
 * @author anviton khloichet
 */
public class ControleurNouveauScore {
    @FXML
    private TextField textField;
    @FXML
    private Label labelScore;

    private final Score score ;
    private final LesScores lesScores;

    /**
     * Contstructeur ControleurNouveauScore
     * @param lesScores vient setter l'attribut lesScores
     * @param score vient setter l'attribut Score
     */
    public ControleurNouveauScore(LesScores lesScores, Score score) {
        this.score = score;
        this.lesScores = lesScores;
    }

    /**
     * Initialise le textfFeld et le labelScore grâce au binding
     */
    public void initialize() {
        StringConverter<Integer> converter = new IntegerStringConverter();
        textField.textProperty().bindBidirectional(score.nomProperty());
        labelScore.textProperty().bindBidirectional(score.tempsProperty(), converter);
    }

    /**
     * Permet de valider l'ajout du score dans la liste des scores
     * et appelle la vue du menu
     * @param bouttonValider événement qui a appelé la méthode
     */
    public void valideScore(ActionEvent bouttonValider) {
        Button b = (Button)bouttonValider.getSource();
        SauveurDeScores sauveurDeScores = new SauveurDeScores();
        Stage stage = (Stage) b.getScene().getWindow();
        GridPane a;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/menu.fxml"));
        lesScores.ajouterScore(score);
        lesScores.trierLesScores();
        try {
            sauveurDeScores.sauver(lesScores, "resources/score/score.txt");
            fxmlLoader.setController(new ControleurMenu(lesScores));
            a = fxmlLoader.load();
            Scene s = new Scene(a, 1000, 1000);
            s.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/vues/style.css")).toExternalForm());
            stage.setTitle("Menu Principal");
            stage.setScene(s);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
