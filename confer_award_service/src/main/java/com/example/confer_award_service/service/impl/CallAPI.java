package com.example.confer_award_service.service.impl;

import com.example.confer_award_service.entity.Customer;
import com.example.confer_award_service.entity.ResponseObject;
import com.example.confer_award_service.entity.Result;
import com.example.confer_award_service.entity.ResultDetail;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CallAPI {
    private static final Logger logger = LoggerFactory.getLogger(CallAPI.class);
    @Autowired
    RestTemplate restTemplate;

    private static final String resultBaseURL =
            "http://result-service";

    private static final String customerBaseURL =
            "http://customer-service";

    private static final String notificatonBaseURL =
            "http://notification-service";

    private static final String validateMicroserviceBaseURL =
            "http://validate-microservice";

    //Phải sửa -> Lấy cả code đã  có người chúng thưởng(status == 1)
    public Result getResultByCode(String code) {
        logger.info("calling result API using RestTemplate");
        ResponseObject result = null;
        try {
            result = restTemplate.getForObject(
                    resultBaseURL + "/result/{code}",
                    ResponseObject.class, code);

            Gson g = new Gson();
            String json = g.toJson(result.getData());
            Result r = g.fromJson(json, Result.class);

            return r;
        } catch(HttpStatusCodeException e) {
           return null;
        }
    }

    public Customer save(Customer customer) {
        logger.info("calling customer API using RestTemplate");
        ResponseObject c = restTemplate.postForObject(customerBaseURL+ "/customer", customer, ResponseObject.class);
        Gson g = new Gson();
        String json = g.toJson(c.getData());
        Customer r = g.fromJson(json, Customer.class);
        return r;
    }

    //Phải sửa
    public Result changeStatus(Result result) {
        logger.info("calling result API using RestTemplate");

        restTemplate.put(
                resultBaseURL + "/result/"+result.getId(),
                result, Result.class);
        return result;
    }

    public void sendNotification(ResultDetail result) {
        logger.info("call notification API using RestTemplate");

        restTemplate.postForObject(
                notificatonBaseURL + "/notification",
                result, Result.class
        );
    }

    public boolean validate(ResultDetail result) {
        logger.info("call validate microservice API using RestTemplate");

        return restTemplate.postForObject(
                validateMicroserviceBaseURL + "/validate",
                result, Boolean.class
        );
    }
}
