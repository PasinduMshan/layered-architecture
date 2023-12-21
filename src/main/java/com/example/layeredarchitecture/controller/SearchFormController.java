package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dao.custom.impl.QueryDAOImpl;
import com.example.layeredarchitecture.model.QueryDTO;
import com.example.layeredarchitecture.view.tdm.QueryTM;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchFormController implements Initializable {

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
    private TableView<QueryTM> tblOrderDetails;

    @FXML
    private TextField txtCode;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;


    QueryDAO queryDAO = new QueryDAOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("total"));

    }

    @FXML
    void btnSearchByDateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<QueryTM> obList = FXCollections.observableArrayList();

        LocalDate date = cmbDate.getValue();
        ArrayList<QueryDTO> detailsOnSearchByDate = queryDAO.getDetailsOnSearchByDate(date);

        for (QueryDTO queryDTO : detailsOnSearchByDate) {
            obList.add(new QueryTM(
                    queryDTO.getCustomerID(),
                    queryDTO.getName(),
                    queryDTO.getAddress(),
                    queryDTO.getOrderID(),
                    queryDTO.getOrderDate(),
                    queryDTO.getDescription(),
                    queryDTO.getQty(),
                    queryDTO.getUnitPrice(),
                    queryDTO.getTotal()
            ));
        }
        tblOrderDetails.setItems(obList);
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