import controleurs.ControleurMenu;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.logique.ChargeurDeScores;
import modele.LesScores;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application{
    @Override
    public void start(Stage stage) {
        GridPane a = null;
        ChargeurDeScores chargeurDeScores = new ChargeurDeScores();
        LesScores lesScores = chargeurDeScores.charger("resources/score/score.txt");
        lesScores.trierLesScores();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/menu.fxml"));
        fxmlLoader.setController(new ControleurMenu(lesScores));
        try {
            a = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert a != null;
        Scene s = new Scene(a, 1000, 1000);
        s.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/vues/style.css")).toExternalForm());
        stage.setTitle("Score");
        stage.setScene(s);
        stage.show();
    }
}
