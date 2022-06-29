package com.example.results_service.service;

import com.example.results_service.entity.Result;

public interface IResultService {
    Result findByCode(String code);
    Result save(Result result);

    Result changeStatus(Result result);
    void delete(long[] ids);
    String randomCode();
}
