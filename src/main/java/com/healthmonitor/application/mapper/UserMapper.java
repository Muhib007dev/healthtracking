package com.healthmonitor.application.mapper;

import com.healthmonitor.application.dto.UserDto;
import com.healthmonitor.application.dto.UserResponse;
import com.healthmonitor.application.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UserMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "country", source = "country")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "primaryContactNumber", source = "primaryContactNumber")
    @Mapping(target = "consultantDoctorName", source = "consultantDoctorName")
    @Mapping(target = "consultantDoctorNumber", source = "consultantDoctorNumber")
    @Mapping(target = "consultantDoctorAddress", source = "consultantDoctorAddress")
    User toUser(UserDto userDto);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "country", source = "country")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "primaryContactNumber", source = "primaryContactNumber")
    @Mapping(target = "consultantDoctorName", source = "consultantDoctorName")
    @Mapping(target = "consultantDoctorNumber", source = "consultantDoctorNumber")
    @Mapping(target = "consultantDoctorAddress", source = "consultantDoctorAddress")
    @Mapping(target = "createdDate", source = "createdDate")
    UserResponse toUserResponse(User user);
}
