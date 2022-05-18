package com.soa.customer_service.controller;

import com.soa.customer_service.entity.Customer;
import com.soa.customer_service.entity.ResponseObject;
import com.soa.customer_service.repository.CustomerRepository;
import com.soa.customer_service.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;


//    @PostMapping("")
//    public Customer createCustomer(@RequestBody Customer customer){
//        return customerService.save(customer);
//    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert customer successfully", customerService.save(customer))
        );
    }

//    @GetMapping("/{id}")
//    public Customer getCustomer(@PathVariable("id") Long id){
//        return customerService.getById(id);
//    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long id){
        customer.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Update customer successfully", customerService.save(customer))
        );
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable("id") Long id) {
        Optional<Customer> foundCustomer = Optional.ofNullable(customerService.getById(id));
        return foundCustomer.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Query customer successfully", foundCustomer)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("FALSE", "Cannot find product with id = " + id, "")
        );
    }

}
