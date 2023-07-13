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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.Model.CustomerModel;
import lk.ijse.Model.MachineDetailModel;
import lk.ijse.Model.MachineModel;
import lk.ijse.Model.RegisterModel;
import lk.ijse.dto.Customer;
import lk.ijse.dto.Machine;
import lk.ijse.dto.MachineDetail;
import lk.ijse.dto.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MachineFormController implements Initializable {

    @FXML
    TableView<MachineDetail> MachineDetailTable;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colMachineId;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtWork;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableView<Machine> machineTable;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colWork;

    @FXML
    private JFXTextField txtEmployeeId;

    @FXML
    private JFXTextField txtMachineId;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXComboBox<?> comStatus;

    @FXML
    void AddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String description = txtName.getText();
        String work = txtWork.getText();
        var machine = new Machine(id, description, work);

        try {
            boolean isSaved = MachineModel.save(machine);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Machine Added Successfully").show();
                getAll();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void DeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean isDelete = MachineModel.delete(id);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION, "Machine Removed Successfully").show();
                getAll();
            }else{
                new Alert(Alert.AlertType.ERROR,"Remove Error").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void UpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String work = txtWork.getText();
        var machine = new Machine(id, name, work);

        try {
            boolean isUpdate = MachineModel.update(machine);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION, "Machine Updated Successfully").show();
                getAll();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void txtNameOnAction(ActionEvent actionEvent) {

    }

    public void txtIdOnAction(ActionEvent actionEvent) {

    }

    public void txtWorkOnAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
        setCellValueFactory1();
        getAll1();
        machineStatus();
    }

    void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("machine_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("description"));
        colWork.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    void setCellValueFactory1() {
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        colMachineId.setCellValueFactory(new PropertyValueFactory<>("machine_id"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    void getAll() {
        try {
            ObservableList<Machine> obList = FXCollections.observableArrayList();
            List<Machine> cusList = MachineModel.getAll();

            for (Machine customer : cusList) {
                obList.add(new Machine(
                        customer.getMachine_id(),
                        customer.getDescription(),
                        customer.getStatus()
                ));
            }
            machineTable.setItems(obList);
        }catch (SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Loading Error!!!").show();
        }
    }

    public void txtEmployeeIdOnAction(ActionEvent actionEvent) {

    }

    public void txtMachineIdOnAction(ActionEvent actionEvent) {

    }

    @FXML
    void btnAddOnAction(ActionEvent actionEvent) {
        String employeeId = txtEmployeeId.getText();
        String machineId = txtMachineId.getText();
        String status = String.valueOf(comStatus.getValue());

        MachineDetail machineDetail = new MachineDetail(employeeId, machineId, status);

        try {
            boolean isSaved = MachineDetailModel.save(machineDetail);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Machine Assigned Successfully").show();
                getAll1();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void btnUpdateOnAction() {
        String employeeId = txtEmployeeId.getText();
        String machineId = txtMachineId.getText();
        String status = String.valueOf(comStatus.getValue());
        MachineDetail machineDetail = new MachineDetail(employeeId,machineId,status);

        try {
            boolean isUpdate = MachineDetailModel.update(machineDetail);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION, "Machine Data Updated Successfully").show();
                getAll1();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void btnRemoveOnAction(ActionEvent actionEvent) {
        String employeeId = txtMachineId.getText();

        try {
            boolean isDelete = MachineDetailModel.remove(employeeId);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION, "Machine Assigned Work Removed Successfully").show();
                getAll1();
            }else{
                new Alert(Alert.AlertType.ERROR,"Delete Error").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void comStatusOnAction(ActionEvent actionEvent) {

    }

    private void machineStatus(){
        ArrayList<String> status=new ArrayList<>();
        status.add("On Mission");
        status.add("Under Constructions");
        status.add("Off Mission");

        ObservableList dataSet = FXCollections.observableList(status);
        comStatus.setItems(dataSet);
    }
    void getAll1() {
        try {
            ObservableList<MachineDetail> obList = FXCollections.observableArrayList();
            List<MachineDetail> mList = MachineDetailModel.getAll1();

            for (MachineDetail machineDetail : mList) {
                obList.add(new MachineDetail(
                        machineDetail.getEmployeeId(),
                        machineDetail.getMachineId(),
                        machineDetail.getStatus()
                ));
            }
            MachineDetailTable.setItems(obList);
        }catch (SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Loading Error!!!").show();
        }
    }
}
