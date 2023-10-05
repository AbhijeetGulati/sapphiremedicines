package com.sapphiremedicines.website.service;

import com.sapphiremedicines.website.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

     Customer getCustomer(int customerIds);

     Customer registerCustomer(Customer customer);
}
