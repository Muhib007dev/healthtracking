package com.healthmonitor.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class UserResponse implements Serializable {

    private Long userId;

    private String name;

    private String username;

    private String password;

    private String country;

    private String address;

    private String primaryContactNumber;

    private String consultantDoctorName;

    private String consultantDoctorNumber;

    private String consultantDoctorAddress;

    private Date createdDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrimaryContactNumber() {
        return primaryContactNumber;
    }

    public void setPrimaryContactNumber(String primaryContactNumber) {
        this.primaryContactNumber = primaryContactNumber;
    }

    public String getConsultantDoctorName() {
        return consultantDoctorName;
    }

    public void setConsultantDoctorName(String consultantDoctorName) {
        this.consultantDoctorName = consultantDoctorName;
    }

    public String getConsultantDoctorNumber() {
        return consultantDoctorNumber;
    }

    public void setConsultantDoctorNumber(String consultantDoctorNumber) {
        this.consultantDoctorNumber = consultantDoctorNumber;
    }

    public String getConsultantDoctorAddress() {
        return consultantDoctorAddress;
    }

    public void setConsultantDoctorAddress(String consultantDoctorAddress) {
        this.consultantDoctorAddress = consultantDoctorAddress;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
