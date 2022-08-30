package com.apiservice.service;

import com.apiservice.model.DeviceDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DeviceService {

    void register(DeviceDTO deviceDTO);
}
