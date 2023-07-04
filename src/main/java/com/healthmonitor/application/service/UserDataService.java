package com.healthmonitor.application.service;

import com.healthmonitor.application.dto.UserDataDto;
import com.healthmonitor.application.dto.UserDataFilter;
import com.healthmonitor.application.dto.UserDataResponse;
import com.healthmonitor.application.model.User;
import com.healthmonitor.application.model.UserData;
import org.springframework.data.domain.Page;

public interface UserDataService {
    UserDataResponse addUserData(UserDataDto userDataDto, User user);

    Page<UserData> getByUserDataFilterAndUser(UserDataFilter userDataFilter, User user);
}
