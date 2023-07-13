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
import lk.ijse.Model.ItemModel;
import lk.ijse.dto.Customer;
import lk.ijse.dto.Item;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {

    @FXML
    private JFXTextField txtItemid;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXComboBox<?> comCatogory;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtUnitprice;

    @FXML
    private TableView<Item> tblItem;

    @FXML
    private TableColumn<?, ?> colItemid;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colCatogory;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitprice;

    @FXML
    void AddOnAction(ActionEvent event) {
        String id = txtItemid.getText();
        String category = (String) comCatogory.getValue();
        String description = txtDescription.getText();
        String qty = txtQty.getText();
        String unitprice = txtUnitprice.getText();
        var customer = new Item(id, category, description, qty, unitprice);

        try {
            boolean isSaved = ItemModel.save(customer);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Item Saved Successfully").show();
                getAll();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void DeleteOnAction(ActionEvent event) {
        String id = txtItemid.getText();

        try {
            boolean isDelete = ItemModel.delete(id);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION, "Item Deleted Successfully").show();
                getAll();
            }else{
                new Alert(Alert.AlertType.ERROR,"Delete Error").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @FXML
    void UpdateOnAction(ActionEvent event) {
        String id = txtItemid.getText();
        String category = (String) comCatogory.getValue();
        String description = txtDescription.getText();
        String qty =txtQty.getText();
        String unit_price =txtUnitprice.getText();
        var item = new Item(id, category, description, qty, unit_price);

        try {
            boolean isUpdate = ItemModel.update(item);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION, "Item Updated Successfully").show();
                getAll();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void comCatogoryOnAction(ActionEvent event) {

    }

    @FXML
    void txtDescriptionOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemidOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {

    }

    @FXML
    void txtUnitpriceOnAction(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCategory();
        setCellValueFactory();
        getAll();
    }

    void setCellValueFactory() {
        colItemid.setCellValueFactory(new PropertyValueFactory<>("item_id"));
        colCatogory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitprice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));
    }

    void getAll() {
        try {
            ObservableList<Item> obList = FXCollections.observableArrayList();
            List<Item> cusList = ItemModel.getAll();

            for (Item item : cusList) {
                obList.add(new Item(
                        item.getItem_id(),
                        item.getCategory(),
                        item.getDescription(),
                        item.getQty(),
                        item.getUnit_price()
                ));
            }
            tblItem.setItems(obList);
        }catch (SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Loading Error!!!").show();
        }
    }

    private void loadCategory(){
        ArrayList<String> accType=new ArrayList<>();
        accType.add("Cup");
        accType.add("Basket");
        accType.add("Spoons");
        accType.add("Chairs");

        ObservableList dataSet = FXCollections.observableList(accType);
        comCatogory.setItems(dataSet);
    }
}
