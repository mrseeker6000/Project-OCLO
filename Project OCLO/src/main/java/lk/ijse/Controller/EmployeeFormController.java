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
import lk.ijse.Model.EmployeeModel;
import lk.ijse.dto.Customer;
import lk.ijse.dto.Employee;
import lk.ijse.dto.tm.AttendanceTM;
import lk.ijse.dto.tm.EmployeeTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeFormController implements Initializable {
    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSallary;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXButton addBtn;

    @FXML
    private TableView<AttendanceTM> tblAttendance;

    @FXML
    private TableColumn<?, ?> colAttendanceId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableView<Employee> tblEmployee;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        setCellValueFactory1();
        getAll();

    }

    void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }
    void setCellValueFactory1(){
        colAttendanceId.setCellValueFactory(new PropertyValueFactory<>("Employee Id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }
    void getAll() {
        try {
            ObservableList<Employee> obList = FXCollections.observableArrayList();
            List<Employee> empList = EmployeeModel.getAll();

            for (Employee employee : empList) {
                obList.add(new Employee(
                        employee.getId(),
                        employee.getName(),
                        employee.getAddress(),
                        employee.getSalary(),
                        employee.getContact()
                ));
            }
            tblEmployee.setItems(obList);
        }catch (SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Loading Error!!!").show();
        }
    }


    public void addBtnOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String salary = txtSallary.getText();
        String contact = txtContact.getText();
        var employee = new Employee(id, name, address, salary, contact);

        try {
            boolean isSaved = EmployeeModel.save(employee);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Saved Successfully").show();
                getAll();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void txtIdOnAction(ActionEvent actionEvent) {

    }

    public void txtNameOnAction(ActionEvent actionEvent) {

    }

    public void txtSallaryOnAction(ActionEvent actionEvent) {

    }

    public void txtAddressOnAction(ActionEvent actionEvent) {

    }

    public void txtContactOnAction(ActionEvent actionEvent) {

    }

    public void deleteBtnOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
            boolean isDelete = EmployeeModel.delete(id);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Deleted Successfully").show();
                getAll();
            }else{
                new Alert(Alert.AlertType.ERROR,"Delete Error").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void updateBtnOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String salary = txtSallary.getText();
        String contact =txtContact.getText();
        var employee = new Employee(id, name, address,salary, contact);

        try {
            boolean isUpdate = EmployeeModel.update(employee);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Updated Successfully").show();
                getAll();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
