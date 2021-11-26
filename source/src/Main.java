import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane a = FXMLLoader.load(getClass().getResource("/menu.fxml"));
        Scene s = new Scene(a, 500, 500);
        s.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(s);
        stage.show();
    }
}
