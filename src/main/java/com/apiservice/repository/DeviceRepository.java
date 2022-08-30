package com.apiservice.repository;

import com.apiservice.model.DeviceVO;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository {

    void deviceInsert(DeviceVO deviceVO);
}
