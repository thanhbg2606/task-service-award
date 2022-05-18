package com.soa.customer_service.service;

import com.soa.customer_service.entity.Customer;

public interface ICustomerService {
    Customer save(Customer customer);

    Customer getById(Long id);
    void delete(long[] ids);
}
