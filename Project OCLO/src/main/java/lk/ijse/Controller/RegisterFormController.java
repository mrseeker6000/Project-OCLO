package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.RegisterModel;
import lk.ijse.dto.Customer;
import lk.ijse.dto.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegisterFormController implements Initializable {

//    public AnchorPane register;
    @FXML
    private AnchorPane register;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXButton registerBtn;

    @FXML
    private JFXButton backBtn;

    @FXML
    private JFXComboBox<?> comboUser;

    @FXML
    private ImageView gmailBtn;

    @FXML
    private ImageView fbBtn;

    @FXML
    void BackOnAction(ActionEvent event) throws IOException {
        Scene stage=new Scene(FXMLLoader.load(getClass().getResource("/view/Login.fxml")));
        Stage window = (Stage) register.getScene().getWindow();
        window.setScene(stage);
    }

    @FXML
    void RegisterOnAction(ActionEvent event) {
        String name = txtName.getText();
        String username = txtUserName.getText();
        String accounttype = String.valueOf(comboUser.getValue());
        String password = txtPassword.getText();
        var User = new User(name, username, accounttype, password);

        try {
            boolean isSaved = RegisterModel.save(User);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "User Registered Successfully").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void FbOnMouseClick(MouseEvent mouseEvent) {
    }

    public void GmailOnMouseClick(MouseEvent mouseEvent) {
    }

    public void txtNameOnAction(ActionEvent actionEvent) {


    }

    public void txtUserNameOnAction(ActionEvent actionEvent) {

    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {

    }

    public void comboUserOnAction(ActionEvent actionEvent) {

    }



    private void loadAccountType(){
        ArrayList<String> accType=new ArrayList<>();
        accType.add("CEO");
        accType.add("Manager");

        ObservableList dataSet = FXCollections.observableList(accType);
        comboUser.setItems(dataSet);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAccountType();
    }
}
