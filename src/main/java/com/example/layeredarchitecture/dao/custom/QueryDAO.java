package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.QueryDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface QueryDAO {
    ArrayList<QueryDTO> getDetailsOnSearchByDate(LocalDate date) throws SQLException, ClassNotFoundException;

    ArrayList<QueryDTO> getDetailsByYearAndMonth(String year,String month) throws SQLException, ClassNotFoundException;
}
