package com.example.layeredarchitecture.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SearchFormController {

    @FXML
    private Label lblTotalAmount;

    @FXML
    private JFXButton btnSearchByDate;

    @FXML
    private JFXButton btnSearchByYearAndMonth;

    @FXML
    private DatePicker cmbDate;

    @FXML
    private ComboBox<?> cmbMonth;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblOrderDetails;

    @FXML
    private TextField txtCode;

    @FXML
    void btnSearchByDateOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchByYearAndMonthOnAction(ActionEvent event) {

    }

    @FXML
    void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

}