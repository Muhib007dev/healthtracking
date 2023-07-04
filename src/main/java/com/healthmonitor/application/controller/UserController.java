package com.healthmonitor.application.controller;

import com.healthmonitor.application.dto.LoginRequest;
import com.healthmonitor.application.dto.UserDto;
import com.healthmonitor.application.dto.UserResponse;
import com.healthmonitor.application.mapper.UserMapper;
import com.healthmonitor.application.model.User;
import com.healthmonitor.application.repository.UserRepository;
import com.healthmonitor.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> login(@Validated @RequestBody UserDto userDto) {
        UserResponse userResponse = userService.createUser(userDto);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    public ResponseEntity<UserResponse> getUser(@RequestHeader("Authorization") String auth){
        return ResponseEntity.ok(userMapper.toUserResponse(userRepository.findByToken(auth)));
    }
}
