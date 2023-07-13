package lk.ijse.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.YearMonth;
import java.util.Date;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Label employeeCount;

    @FXML
    private Label dateLbl;

    @FXML
    private Label timeLbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDate();
    }
    void getDate(){
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        dateLbl.setText(String.valueOf(sqlDate));
    }
}
