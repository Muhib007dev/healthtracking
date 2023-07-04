package com.healthmonitor.application.serviceimpl;

import com.healthmonitor.application.dto.UserDataDto;
import com.healthmonitor.application.dto.UserDataFilter;
import com.healthmonitor.application.dto.UserDataResponse;
import com.healthmonitor.application.mapper.UserDataMapper;
import com.healthmonitor.application.model.User;
import com.healthmonitor.application.model.UserData;
import com.healthmonitor.application.repository.UserDataRepository;
import com.healthmonitor.application.service.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    private final UserDataRepository userDataRepository;

    private final UserDataMapper userDataMapper;

    @Override
    public UserDataResponse addUserData(UserDataDto userDataDto, User user) {
        UserData userData = userDataMapper.toUserData(userDataDto);
        userData.setUser(user);
        return userDataMapper.toUserDataResponse(userDataRepository.save(userData));
    }

    @Override
    public Page<UserData> getByUserDataFilterAndUser(UserDataFilter filter, User user) {
        if (filter.getOrder() == null) {
            filter.setOrder(Sort.Direction.ASC);
        }
        if (filter.getOrderBy() == null) {
            filter.setOrderBy("createdDate");
        }

        Pageable pageable = getPageRequestCustom(filter.getPage(), filter.getSize(), filter.getOrder(), filter.getOrderBy());
        if (filter.getBodyMovement()) {
            return userDataRepository.findByUserAndBodyMovementNotNull(user,pageable);
        } else if (filter.getBodyTemperature()) {
            return userDataRepository.findByUserAndBodyTemperatureNotNull(user,pageable);
        } else if (filter.getHumidity()) {
            return userDataRepository.findByUserAndHumidityNotNull(user,pageable);
        } else if (filter.getPulse()) {
            return userDataRepository.findByUserAndPulseNotNull(user,pageable);
        } else if (filter.getTemperature()) {
            return userDataRepository.findByUserAndTemperatureNotNull(user,pageable);
        } else {
            return userDataRepository.findByUser(user,pageable);
        }
    }

    private PageRequest getPageRequestCustom(int page, int size, Sort.Direction direction, String orderby) {
        return PageRequest.of(page, size, direction, orderby);
    }
}
