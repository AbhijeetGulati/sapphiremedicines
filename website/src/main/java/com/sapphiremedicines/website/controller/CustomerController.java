package com.sapphiremedicines.website.controller;

import com.sapphiremedicines.website.entity.Customer;
import com.sapphiremedicines.website.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }

    @PostMapping()
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.registerCustomer(customer));
    }






}
