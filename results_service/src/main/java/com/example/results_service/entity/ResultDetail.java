package com.example.results_service.entity;

import java.util.Date;

public class ResultDetail{
   private Result result;
   private Customer customer;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
