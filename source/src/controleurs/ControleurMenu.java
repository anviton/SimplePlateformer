package controleurs;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import modele.LesScores;


import java.io.IOException;
import java.net.URL;


public class ControleurMenu{

    private final LesScores lesScores;

    public ControleurMenu(LesScores lesScores) {
        super();
        this.lesScores = lesScores;
    }

    public void quitter(ActionEvent buttonquitter) {
        Button b = (Button)buttonquitter.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
    }

    public void afficheScores(ActionEvent bouttonScore) {
        Stage fenetreScores = new Stage();
        BorderPane a;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vues/listeScores.fxml"));
        fxmlLoader.setController(new ControleurListeScores(lesScores));
        try {
            a = fxmlLoader.load();
            Scene s = new Scene(a, 500, 500);
            fenetreScores.setTitle("Scores");
            s.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
            fenetreScores.setScene(s);
            fenetreScores.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toNiveau(ActionEvent event) throws IOException {
        URL vue = getClass().getResource("/vues/niveaux.fxml");
        FXMLLoader chargeur = new FXMLLoader();
        chargeur.setController(new ControleurNiveaux(lesScores));
        chargeur.setLocation(vue);
        Parent parent = chargeur.load();
        Scene scene = new Scene(parent,1000,1000);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
