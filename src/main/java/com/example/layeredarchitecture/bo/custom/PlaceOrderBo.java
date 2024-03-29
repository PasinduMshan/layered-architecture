package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo extends SuperDAO {
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
    ItemDTO findItem(String code);
    CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
    boolean existItem(String code) throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    String generateNewOrderId() throws SQLException, ClassNotFoundException;
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
}
