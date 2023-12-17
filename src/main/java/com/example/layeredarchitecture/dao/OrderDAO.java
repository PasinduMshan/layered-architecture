package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {
    String generateNewOderId() throws SQLException, ClassNotFoundException;
    boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

}