package com.example.layeredarchitecture.view.tdm;

import java.math.BigDecimal;
import java.time.LocalDate;

public class QueryTM {
    private String CustomerID;
    private String Name;
    private String Address;
    private String OrderID;
    private LocalDate orderDate;
    private String Description;
    private int qty;
    private BigDecimal unitPrice;
    private BigDecimal total;

    public QueryTM() {
    }

    public QueryTM(String customerID, String name, String address, String orderID, LocalDate orderDate, String description, int qty, BigDecimal unitPrice, BigDecimal total) {
        CustomerID = customerID;
        Name = name;
        Address = address;
        OrderID = orderID;
        this.orderDate = orderDate;
        Description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "QueryTM{" +
                "CustomerID='" + CustomerID + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", OrderID='" + OrderID + '\'' +
                ", orderDate=" + orderDate +
                ", Description='" + Description + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                '}';
    }
}
