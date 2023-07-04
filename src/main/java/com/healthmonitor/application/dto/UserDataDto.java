package com.healthmonitor.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDataDto implements Serializable {

    private Double bodyTemperature;

    private String bodyMovement;

    private Double humidity;

    private Double temperature;

    private Integer pulse;

}
