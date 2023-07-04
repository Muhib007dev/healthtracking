package com.healthmonitor.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "UserInfo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    @Column(unique = true)
    private String username;

    private String password;

    private String country;

    private String address;

    private String primaryContactNumber;

    private String consultantDoctorName;

    private String consultantDoctorNumber;

    private String consultantDoctorAddress;

    private String token;

    @CreationTimestamp
    private Date createdDate;

}
