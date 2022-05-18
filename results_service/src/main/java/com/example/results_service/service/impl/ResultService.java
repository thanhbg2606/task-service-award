package com.example.results_service.service.impl;

import com.example.results_service.entity.Result;
import com.example.results_service.repository.ResultRepository;
import com.example.results_service.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
