package com.healthmonitor.application.serviceimpl;

import com.healthmonitor.application.dto.UserDto;
import com.healthmonitor.application.dto.UserResponse;
import com.healthmonitor.application.mapper.UserMapper;
import com.healthmonitor.application.model.User;
import com.healthmonitor.application.repository.UserRepository;
import com.healthmonitor.application.service.UserService;
import com.healthmonitor.application.utility.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        user.setToken(JwtTokenUtil.generateToken(user.getUsername(),user.getPassword()));
        return userMapper.toUserResponse(userRepository.save(user));
    }
}
