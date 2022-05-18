package com.soa.customer_service.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column private String address;

    @Column private String email;

    @Column
    @CreatedDate
    private Date rewardedDay;

    @Column
    private Long ResultId;

    public Long getResultId() {
        return ResultId;
    }

    public void setResultId(Long resultId) {
        ResultId = resultId;
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
