package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.dto.Customer;
import lk.ijse.dto.tm.CustomerTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {
    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setCellValueFactory();
        getAll();
    }

    void setCellValueFactory() {
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    void getAll() {
        try {
            ObservableList<Customer> obList = FXCollections.observableArrayList();
            List<Customer> cusList = CustomerModel.getAll();

            for (Customer customer : cusList) {
                obList.add(new Customer(
                        customer.getNic(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getContact()
                ));
            }
            tblCustomer.setItems(obList);
        }catch (SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Loading Error!!!").show();
        }
    }
    @FXML
    void addBtnOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        var customer = new Customer(id, name, address, contact);

        try {
            boolean isSaved = CustomerModel.save(customer);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved Successfully").show();
                getAll();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @FXML
    void updateBtnOnAction(ActionEvent event) throws SQLException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact =txtContact.getText();
        var customer = new Customer(id, name, address, contact);

        try {
            boolean isUpdate = CustomerModel.update(customer);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated Successfully").show();
                getAll();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteBtnOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
            boolean isDelete = CustomerModel.delete(id);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted Successfully").show();
                getAll();
            }else{
                new Alert(Alert.AlertType.ERROR,"Delete Error").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
