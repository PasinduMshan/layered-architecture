package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.bo.custom.impl.CustomerBoImpl;
import com.example.layeredarchitecture.bo.custom.impl.PlaceOrderBoImpl;
import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.QueryDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }
    public static BOFactory getBoFactory() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER, ITEM, PLACE_ORDER, QUERY
    }

    public SuperDAO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemDAOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBoImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }

}
