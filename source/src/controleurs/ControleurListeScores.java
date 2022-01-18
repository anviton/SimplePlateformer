package controleurs;

import controleurs.util.IntegerSpinnerTableCell;
import javafx.fxml.FXML;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import modele.GestionnaireDeFichiers;
import modele.Score;
import modele.metier.LesScores;


public class ControleurListeScores {
    @FXML
    private TableView<Score> table;

    private LesScores lesScores;

    private final TableColumn<Score, String> columnNom = new TableColumn<>("Nom");
    private final TableColumn<Score, Integer> colonneNiveau = new TableColumn<>("Niveau");
    private final TableColumn<Score, Integer> colonneTemps = new TableColumn<>("Temps");

    public void initialize() {
        try {
            lesScores = GestionnaireDeFichiers.lecture("resources/score/score.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        table.getColumns().add(columnNom);

        colonneNiveau.setCellValueFactory(new PropertyValueFactory<>("numNiveau"));
        table.getColumns().add(colonneNiveau);

        colonneTemps.setCellValueFactory(new PropertyValueFactory<>("temps"));
        table.getColumns().add(colonneTemps);

        table.itemsProperty().bind(lesScores.lesScoresProperty());

        colonneTemps.setCellFactory(IntegerSpinnerTableCell.<Score>forTableColumn());
        columnNom.setCellFactory(TextFieldTableCell.<Score>forTableColumn());
        colonneNiveau.setCellFactory(IntegerSpinnerTableCell.<Score>forTableColumn());

    }
}
