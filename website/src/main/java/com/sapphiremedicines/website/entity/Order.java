package com.sapphiremedicines.website.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_details")
public class Order {
    @Id
    private int orderId;
    //note:orderid is not being generated it is coming out as 0

    private String orderDetails;

//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }
//    private int quantity;
//
//    private String skuid;
//
//    private String address;
//
//    private String couponcode;
//
//    private String name;
//
//    public String getSkuid() {
//        return skuid;
//    }
//
//    public void setSkuid(String skuid) {
//        this.skuid = skuid;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getCouponcode() {
//        return couponcode;
//    }
//
//    public void setCouponcode(String couponcode) {
//        this.couponcode = couponcode;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    private String phoneNumber;
//
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }


    //    private List<Integer> productId;
//    private int customerId;
}
