package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.QueryDTO;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<QueryDTO> getDetailsOnSearchByDate(LocalDate date) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT c.id,c.name,c.address,o.oid,o.date,i.description,od.qty,od.unitPrice " +
                "FROM OrderDetails od LEFT JOIN Item i ON od.itemCode = i.code LEFT JOIN Orders o ON od.oid = o.oid LEFT " +
                "JOIN Customer c ON o.customerID = c.id WHERE o.date = ?", date);
        ArrayList<QueryDTO> list = new ArrayList<>();

        while (rst.next()) {
            String customerId = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            String orderID = rst.getString(4);
            LocalDate orderDate = rst.getDate(5).toLocalDate();
            String description = rst.getString(6);
            int qty = rst.getInt(7);
            BigDecimal unitPrice = BigDecimal.valueOf(rst.getDouble(8));
            BigDecimal total = BigDecimal.valueOf(qty * rst.getDouble(8));

            list.add(new QueryDTO(customerId,name,address,orderID,orderDate,description,qty,unitPrice,total));
        }

        return list;
    }
    @Override
    public ArrayList<QueryDTO> getDetailsByYearAndMonth(String year,String month) throws SQLException, ClassNotFoundException {

        String yearMonth = year+"-"+month+"%";

        ResultSet rst = SQLUtil.execute("SELECT c.id,c.name,c.address,o.oid,o.date,i.description,od.qty,od.unitPrice " +
                "FROM OrderDetails od LEFT JOIN Item i ON od.itemCode = i.code LEFT JOIN Orders o ON od.oid = o.oid LEFT " +
                "JOIN Customer c ON o.customerID = c.id WHERE o.date Like ?",yearMonth);

        ArrayList<QueryDTO> list = new ArrayList<>();

        while (rst.next()) {
            String customerId = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            String orderID = rst.getString(4);
            LocalDate orderDate = rst.getDate(5).toLocalDate();
            String description = rst.getString(6);
            int qty = rst.getInt(7);
            BigDecimal unitPrice = BigDecimal.valueOf(rst.getDouble(8));
            BigDecimal total = BigDecimal.valueOf(qty * rst.getDouble(8));

            list.add(new QueryDTO(customerId,name,address,orderID,orderDate,description,qty,unitPrice,total));
        }

        return list;
    }
}
