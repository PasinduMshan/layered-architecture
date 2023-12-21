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
import java.math.BigDecimal;
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
    private ComboBox<Object> cmbMonth;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<QueryTM> tblOrderDetails;

    @FXML
    private TextField txtYear;

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

    private String[] AllMonth;

    QueryDAO queryDAO = new QueryDAOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllMonth();
    }

    private void loadAllMonth() {
        ObservableList<Object> obList = FXCollections.observableArrayList();

        AllMonth = new String[]{"JANUARY", "0FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER"
                , "OCTOBER", "NOVEMBER", "DECEMBER"};

        for (String months : AllMonth) {
            obList.add(months);
        }

        cmbMonth.setItems(obList);
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
    void btnSearchByDateOnAction(ActionEvent event) {
        ObservableList<QueryTM> obList = FXCollections.observableArrayList();

        LocalDate date = cmbDate.getValue();

        BigDecimal total = new BigDecimal(0);

        try {
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
                total = total.add(queryDTO.getTotal());
            }
            tblOrderDetails.setItems(obList);
            lblTotalAmount.setText(String.valueOf(total));
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }


    }

    @FXML
    void btnSearchByYearAndMonthOnAction(ActionEvent event) {
        String year = txtYear.getText();
        String month = (String) cmbMonth.getValue();

        String monthNo = null;

        for (int i = 0; i < AllMonth.length; i++) {
            if (month.equals(AllMonth[i])) {
                monthNo = String.valueOf((i+1));
            }
        }

        ObservableList<QueryTM> obList = FXCollections.observableArrayList();

        BigDecimal total = new BigDecimal(0);
        try {
            ArrayList<QueryDTO> detailsByYearAndMonth = queryDAO.getDetailsByYearAndMonth(year, monthNo);

            for (QueryDTO queryDTO : detailsByYearAndMonth) {
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
                total = total.add(queryDTO.getTotal());
            }
            tblOrderDetails.setItems(obList);
            lblTotalAmount.setText(String.valueOf(total));
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
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