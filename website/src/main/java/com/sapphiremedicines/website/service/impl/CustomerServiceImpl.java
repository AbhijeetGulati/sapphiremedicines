package com.sapphiremedicines.website.service.impl;

import com.sapphiremedicines.website.entity.Customer;
import com.sapphiremedicines.website.repository.CustomerRepository;
import com.sapphiremedicines.website.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(int customerIds) {
        return customerRepository.findById(customerIds).orElseThrow();
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
