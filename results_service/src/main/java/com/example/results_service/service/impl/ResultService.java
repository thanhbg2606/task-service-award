package com.example.results_service.service.impl;

import com.example.results_service.entity.Result;
import com.example.results_service.repository.ResultRepository;
import com.example.results_service.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ResultService implements IResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Result findByCode(String code) {
        return resultRepository.findByCode(code);
    }

    @Override
    public Result save(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public Result changeStatus(Result result) {
        return null;
    }

    @Override
    public void delete(long[] ids) {

    }

    @Override
    public String randomCode() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz";
        Random rnd = new Random();
        int len = 20;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}
