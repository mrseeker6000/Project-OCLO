package lk.ijse.Controller;
import com.sun.javafx.stage.EmbeddedWindow;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.print.DocFlavor;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;


public class NavigatorCEOController implements Initializable {
    public AnchorPane homepage;
    public Label dateLbl;
    public Label timeLbl;

    public void LogoutOnAction(ActionEvent actionEvent) throws IOException {}

    public void machineOnAction(ActionEvent actionEvent) throws IOException {Parent node= FXMLLoader.load(getClass().getResource("/view/Machine_Form.fxml"));homepage.getChildren().clear();homepage.getChildren().addAll(node);}

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        homepage.getChildren().clear();
        homepage.getChildren().addAll(node);
    }



    public void itemOnAction(ActionEvent actionEvent) throws IOException {Parent node= FXMLLoader.load(getClass().getResource("/view/Item_Form.fxml"));homepage.getChildren().clear();homepage.getChildren().addAll(node);}

    public void ordersOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/place_order_form.fxml"));
        homepage.getChildren().clear();
        homepage.getChildren().addAll(node);}

    public void employeeOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/Employee_Form.fxml"));
        homepage.getChildren().clear();
        homepage.getChildren().addAll(node);
    }

    public void usersOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/Users_Form.fxml"));
        homepage.getChildren().clear();
        homepage.getChildren().addAll(node);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Parent node= null;
        try {
            node = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
            homepage.getChildren().clear();
            homepage.getChildren().addAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void customerOnAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/Customer_Form.fxml"));
        homepage.getChildren().clear();
        homepage.getChildren().addAll(node);
    }
}
