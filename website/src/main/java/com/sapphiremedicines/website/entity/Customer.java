package com.sapphiremedicines.website.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer_details")
public class Customer {

    @Id
    private int customerId;

    private String customerName;

    private String customerContact;

    private String customer_email;

}
