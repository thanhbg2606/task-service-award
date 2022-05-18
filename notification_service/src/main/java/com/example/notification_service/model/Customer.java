package com.example.notification_service.model;

import java.util.Date;

public class Customer {
    private Long id;
    private String name;
    private String address;
    private String email;
    private Date rewardedDay;

    private Long resultId;

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRewardedDay() {
        return rewardedDay;
    }

    public void setRewardedDay(Date rewardedDay) {
        this.rewardedDay = rewardedDay;
    }
}
