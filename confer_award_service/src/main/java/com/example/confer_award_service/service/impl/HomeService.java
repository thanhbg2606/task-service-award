package com.example.confer_award_service.service.impl;

import com.example.confer_award_service.entity.Customer;
import com.example.confer_award_service.entity.Result;
import com.example.confer_award_service.entity.ResultDetail;
import com.example.confer_award_service.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService implements IHomeService {

    @Autowired
    private CallAPI callAPI;

    @Override
    public String SubmitForm(ResultDetail rd) {
        if(!callAPI.validate(rd)){
            return "Thông tin không hợp lệ";
        }

        Result result = callAPI.getResultByCode(rd.getResult().getCode());
        if(result == null) return "Mã số không trúng thưởng";

        rd.getCustomer().setResultId(result.getId());

        Customer c = callAPI.save(rd.getCustomer());

        callAPI.changeStatus(result);
        callAPI.sendNotification(rd);
        return "Chúc mừng khách hàng " + c.getName()+ " đã trúng thưởng "+ result.getCode();
    }
}
