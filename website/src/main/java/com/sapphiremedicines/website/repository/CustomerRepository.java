package com.sapphiremedicines.website.repository;

import com.sapphiremedicines.website.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
