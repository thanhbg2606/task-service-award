package com.soa.customer_service.service.impl;

import com.soa.customer_service.dto.CustomerDTO;
import com.soa.customer_service.entity.Customer;
import com.soa.customer_service.repository.CustomerRepository;
import com.soa.customer_service.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long[] ids) {
        for(long item: ids) {
            customerRepository.deleteById(item);
        }
    }
}
