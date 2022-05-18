package com.example.results_service.service.impl;

import com.example.results_service.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallAPI {

    private static final Logger logger = LoggerFactory.getLogger(CallAPI.class);
    @Autowired
    RestTemplate restTemplate;

    private static final String customerBaseURL =
            "http://customer-service";

    public Customer save(int id) {
        logger.info("calling course microservice API using RestTemplate");

        Customer customer = restTemplate.getForObject(
                customerBaseURL + "/customer/{id}",
                Customer.class, id);
        return customer;
    }
}
