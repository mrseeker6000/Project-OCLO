import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    @Override
    public void start(final Stage primaryStage) throws IOException {
          primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/place_order_form.fxml"))));
          primaryStage.show();
    }
}
