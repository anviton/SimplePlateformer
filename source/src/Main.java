import controleurs.ControleurMenu;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.logique.GestionnaireDeFichiers;
import modele.LesScores;

import java.io.IOException;

public class Main extends Application{
    @Override
    public void start(Stage stage) {
        GridPane a = null;
        LesScores lesScores = GestionnaireDeFichiers.lecture("resources/score/score.txt");
        lesScores.trierLesScores();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/menu.fxml"));
        fxmlLoader.setController(new ControleurMenu(lesScores));
        try {
            a = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene s = new Scene(a, 1000, 1000);
        s.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
        stage.setTitle("Score");
        stage.setScene(s);
        stage.show();
    }
}
