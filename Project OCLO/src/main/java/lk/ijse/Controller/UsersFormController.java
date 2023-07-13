package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.UserModel;
import lk.ijse.dto.Customer;
import lk.ijse.dto.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UsersFormController implements Initializable {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<User> tblUser;

    @FXML
    private TableColumn<?, ?> colUsername;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAccountType;

    @FXML
    private JFXComboBox<?> comAccountType;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String username = txtUsername.getText();
        String name = txtName.getText();
        String accountType = (String) comAccountType.getValue();
        String password = txtPassword.getText();
        var user = new User(username, name, accountType, password);

        try {
            boolean isSaved = UserModel.save(user);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "User Saved Successfully").show();
                getAll();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void comAccountTypeOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
        loadAccountType();
    }

    void setCellValueFactory() {
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAccountType.setCellValueFactory(new PropertyValueFactory<>("password"));
    }

    void getAll() {
        try {
            ObservableList<User> obList = FXCollections.observableArrayList();
            List<User> userList = UserModel.getAll();

            for (User user : userList) {
                obList.add(new User(
                        user.getUsername(),
                        user.getName(),
                        user.getAccountType()
                ));
            }
            tblUser.setItems(obList);
        }catch (SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Loading Error!!!").show();
        }
    }
    private void loadAccountType(){
        ArrayList<String> accType=new ArrayList<>();
        accType.add("CEO");
        accType.add("Manager");

        ObservableList dataSet = FXCollections.observableList(accType);
        comAccountType.setItems(dataSet);
    }
}
