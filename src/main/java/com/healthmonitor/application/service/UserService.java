package com.healthmonitor.application.service;

import com.healthmonitor.application.dto.UserDto;
import com.healthmonitor.application.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserDto userDto);
}
