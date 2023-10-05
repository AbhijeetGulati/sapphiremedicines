package com.sapphiremedicines.website.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="product_details")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private int productId;

    private String productName;

    private String productCategory;

    private String bodyPart;

    private String variant;

    private float MRP;

    private float sellingPrice;

//    @ManyToOne
//    @JoinColumn(name="orderId")
//    Order order;

}
