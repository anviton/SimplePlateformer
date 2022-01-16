import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application{
    @Override
    public void start(Stage stage) {

        GridPane a = null;
        try {
            a = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/vues/menu.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene s = new Scene(a, 1000, 1000);
        s.getStylesheets().add(getClass().getResource("/vues/style.css").toExternalForm());
        stage.setTitle("Menu Principal");
        stage.setScene(s);
        stage.show();
    }
}
