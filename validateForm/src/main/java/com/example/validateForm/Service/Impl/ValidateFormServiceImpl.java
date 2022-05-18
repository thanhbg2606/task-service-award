package com.example.validateForm.Service.Impl;

import com.example.validateForm.Service.ValidateFormService;
import com.example.validateForm.model.EmailExample;
import com.example.validateForm.model.ResultDetail;
import org.springframework.stereotype.Service;

@Service
public class ValidateFormServiceImpl implements ValidateFormService {

    private static EmailExample emailExample;

    @Override
    public Boolean checkForm(ResultDetail form) {
        emailExample = new EmailExample();
        boolean isvalidEmail = emailExample.validate(  form.getCustomer().getEmail());
        if (isvalidEmail == true && !form.getCustomer().getName().equals("") && !form.getCustomer().getAddress().equals("") && !form.getResult().getCode().equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
