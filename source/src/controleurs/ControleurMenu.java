package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControleurMenu {
    @FXML
    //private VBox box;


    public void quitter(ActionEvent buttonquitter) {
        Button b = (Button)buttonquitter.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
    }

    public void afficheOption(ActionEvent buttonOption) throws IOException {
        Stage fenetreOption = new Stage();
        AnchorPane a;
        a = FXMLLoader.load(getClass().getResource("/Vues/Options.fxml"));
        Scene s = new Scene(a, 500, 500);
        fenetreOption.setTitle("Options");
        s.getStylesheets().add(getClass().getResource("/Vues/style.css").toExternalForm());
        fenetreOption.setScene(s);
        fenetreOption.show();
    }

    public void afficheNiveau(ActionEvent bouttonNiveau){
        Button b = (Button)bouttonNiveau.getSource();

        Stage stage = (Stage) b.getScene().getWindow();
        stage.setMaximized(true);

        Canvas c = new Canvas(3000, 2500);
        GraphicsContext gc = c.getGraphicsContext2D();
        GridPane g = new GridPane();
        g.setStyle("-fx-background-image: url('/fond1.png'); -fx-background-repeat: no-repeat; -fx-background-size: 3000 2200; -fx-background-position: center center;");
        g.getChildren().add(c);
        Scene s = new Scene(g);

        stage.setScene(s);
        Jeu j = new Jeu();
        j.lancerBoucleDeJeu(gc, s);
    }
}
