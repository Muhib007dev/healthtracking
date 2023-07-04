package com.healthmonitor.application.controller;

import com.healthmonitor.application.dto.UserDataDto;
import com.healthmonitor.application.dto.UserDataFilter;
import com.healthmonitor.application.dto.UserDataResponse;
import com.healthmonitor.application.dto.UserDto;
import com.healthmonitor.application.dto.UserResponse;
import com.healthmonitor.application.model.User;
import com.healthmonitor.application.model.UserData;
import com.healthmonitor.application.repository.UserDataRepository;
import com.healthmonitor.application.repository.UserRepository;
import com.healthmonitor.application.service.UserDataService;
import com.healthmonitor.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user-data")
@RequiredArgsConstructor
public class UserDataController {

    private final UserDataService userDataService;

    private final UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<UserDataResponse> add(@Validated @RequestBody UserDataDto userDataDto, @RequestHeader("Authorization") String auth ) {
        User user = userRepository.findByToken(auth);
        if(user == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        UserDataResponse userDataResponse = userDataService.addUserData(userDataDto,user);
        return ResponseEntity.ok(userDataResponse);
    }

    @PostMapping("/filter")
    public ResponseEntity<Page<UserData>> filter(@Validated @RequestBody UserDataFilter userDataFilter, @RequestHeader("Authorization") String auth ) {
        User user = userRepository.findByToken(auth);
        if(user == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        Page<UserData> userDataResponse = userDataService.getByUserDataFilterAndUser(userDataFilter,user);
        return ResponseEntity.ok(userDataResponse);
    }
}
