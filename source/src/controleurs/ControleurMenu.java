package controleurs;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modele.*;
import modele.logique.ChargeurNiveau;
import modele.metier.Niveau;

import java.io.IOException;
import java.util.Objects;

public class ControleurMenu extends ControleurObservateur{

    private Jeu jeu;
    Stage stage;
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
        a = FXMLLoader.load(getClass().getResource("/vues/options.fxml"));
        Scene s = new Scene(a, 500, 500);
        fenetreOption.setTitle("Options");
        s.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
        fenetreOption.setScene(s);
        fenetreOption.show();
    }

    public void afficheNiveau(ActionEvent bouttonNiveau){
        Button b = (Button)bouttonNiveau.getSource();
        ChargeurNiveau chargeur =  new ChargeurNiveau();
        Niveau n = chargeur.chargerNiveau("resources/niveaux/niveau1.niv");

        this.stage = (Stage) b.getScene().getWindow();
        stage.setMaximized(true);
        Canvas c = new Canvas((n.getLargeurNiveau() + 1) * 50, (n.getHauteurNiveau() + 1) * 50);
        GraphicsContext gc = c.getGraphicsContext2D();

        //g.setStyle("-fx-background-image: url('/fond1.png'); -fx-background-repeat: no-repeat; -fx-background-size: 100%; -fx-background-position: center center;");
        //g.getChildren().add(c);
        Pane pane = new Pane();
        pane.getChildren().add(new ImageView(new Image(n.getCheminFond(), c.getWidth(), c.getHeight(), false, true)));
        pane.getChildren().add(c);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        Scene s = b.getScene();
        stage.setTitle("Niveau1");
        s.setRoot(scrollPane);
        jeu = new Jeu(n);
        jeu.lancerBoucleDeJeu(gc, s);
        jeu.attacher(this);

    }

    @Override
    public void mettreAJour(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                stage.setMaximized(false);
                GridPane a = null;
                try {
                    a = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/vues/nouveauScore.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene s = new Scene(a, 1000, 1000);
                s.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
                stage.setTitle("Score");
                stage.setScene(s);
                stage.show();
            }
        });
    }
}
