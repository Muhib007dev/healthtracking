package com.healthmonitor.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserDataResponse implements Serializable {

    private Long userDataId;

    private String username;

    private Double bodyTemperature;

    private String bodyMovement;

    private Double humidity;

    private Double temperature;

    private Integer pulse;

    private Date createdDate;
}
