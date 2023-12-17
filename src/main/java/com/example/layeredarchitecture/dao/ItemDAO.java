package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ItemDAO {
    ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException;

    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;

    boolean saveItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;

}
