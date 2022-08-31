package com.apiservice.service;

import com.apiservice.model.*;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public interface DeviceService {

    void register(DeviceDTO deviceDTO , ApiDTO apiDTO);

    void delete(Integer serviceNumber , DeviceDTO deviceDTO);

    ListResponseDTO<DeviceDTO> getList(ListDTO listDTO);
}
