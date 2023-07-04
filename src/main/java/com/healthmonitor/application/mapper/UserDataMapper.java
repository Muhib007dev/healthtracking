package com.healthmonitor.application.mapper;

import com.healthmonitor.application.dto.UserDataDto;
import com.healthmonitor.application.dto.UserDataResponse;
import com.healthmonitor.application.model.UserData;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UserDataMapper {

    @Mapping(target = "bodyTemperature", source = "bodyTemperature")
    @Mapping(target = "bodyMovement", source = "bodyMovement")
    @Mapping(target = "humidity", source = "humidity")
    @Mapping(target = "temperature", source = "temperature")
    @Mapping(target = "pulse", source = "pulse")
    UserData toUserData(UserDataDto userDataDto);

    @Mapping(target = "userDataId", source = "bodyTemperature")
    @Mapping(target = "bodyTemperature", source = "bodyTemperature")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "bodyMovement", source = "bodyMovement")
    @Mapping(target = "humidity", source = "humidity")
    @Mapping(target = "temperature", source = "temperature")
    @Mapping(target = "pulse", source = "pulse")
    @Mapping(target = "createdDate", source = "createdDate")
    UserDataResponse toUserDataResponse(UserData userData);
}
