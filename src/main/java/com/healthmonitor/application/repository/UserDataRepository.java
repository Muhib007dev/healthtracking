package com.healthmonitor.application.repository;

import com.healthmonitor.application.dto.UserDataResponse;
import com.healthmonitor.application.model.User;
import com.healthmonitor.application.model.UserData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData,Long> {
    Page<UserData> findByUserAndBodyMovementNotNull(User user, Pageable pageable);

    Page<UserData> findByUserAndBodyTemperatureNotNull(User user, Pageable pageable);

    Page<UserData> findByUserAndHumidityNotNull(User user, Pageable pageable);

    Page<UserData> findByUserAndPulseNotNull(User user, Pageable pageable);

    Page<UserData> findByUserAndTemperatureNotNull(User user, Pageable pageable);

    Page<UserData> findByUser(User user, Pageable pageable);
}
