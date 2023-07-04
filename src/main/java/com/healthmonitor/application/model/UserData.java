package com.healthmonitor.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDataId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "userId", nullable = false)
    private User user;

    private Double bodyTemperature;

    private String bodyMovement;

    private Double humidity;

    private Double temperature;

    private Integer pulse;

    @CreationTimestamp
    private Date createdDate;

}
