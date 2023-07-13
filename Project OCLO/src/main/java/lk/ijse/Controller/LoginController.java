package lk.ijse.Controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Model.LoginModel;
import lk.ijse.db.DataBaseConnection;
import lk.ijse.dto.User;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private AnchorPane login;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXButton registerBtn;

    @FXML
    private JFXButton loginExitBtn;

    @FXML
    private ImageView gmailBtn;

    @FXML
    private ImageView fbBtn;

    @FXML
    void ExitOnAction(ActionEvent event) {
        Stage stage = (Stage) loginExitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void GoRegisterFormOnAction(ActionEvent event) throws IOException {
        Scene stage = new Scene(FXMLLoader.load(getClass().getResource("/view/Register_Form.fxml")));
        Stage window = (Stage) login.getScene().getWindow();
        window.setScene(stage);
    }

    @FXML
    void loginOnAction(ActionEvent event) throws IOException, SQLException {

                Scene stage = new Scene(FXMLLoader.load(getClass().getResource("/view/Navigator_CEO.fxml")));
                Stage window = (Stage) login.getScene().getWindow();
                window.setScene(stage);


    }


    public void GmailOnMouseClick(MouseEvent mouseEvent) {
    }

    public void FbOnMouseClick(MouseEvent mouseEvent) {
    }

    public void txtUsernameOnAction(ActionEvent actionEvent) {

    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {

    }

}
