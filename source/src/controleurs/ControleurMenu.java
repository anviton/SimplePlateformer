package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControleurMenu {
    @FXML
    //private VBox box;


    public void quitter(ActionEvent buttonquitter) {
        Button b = (Button)buttonquitter.getSource();
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
}
