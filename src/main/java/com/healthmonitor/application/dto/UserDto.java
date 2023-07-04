package com.healthmonitor.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private Long userId;

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(min = 4)
    private String username;

    @NotBlank
    @Size(min = 7)
    private String password;

    private String country;

    private String address;

    private String primaryContactNumber;

    private String consultantDoctorName;

    private String consultantDoctorNumber;

    private String consultantDoctorAddress;

}
