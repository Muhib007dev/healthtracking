package com.healthmonitor.application.dto;

import lombok.Data;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@Data
public class UserDataFilter implements Serializable {
    private Integer page;
    private Integer size;
    private Sort.Direction order;
    private String orderBy;

    private Boolean bodyTemperature;

    private Boolean bodyMovement;

    private Boolean humidity;

    private Boolean temperature;

    private Boolean pulse;
}
