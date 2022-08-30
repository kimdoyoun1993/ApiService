package com.apiservice.service;

import com.apiservice.model.DeviceDTO;
import com.apiservice.model.DeviceVO;
import com.apiservice.repository.ApiRepository;
import com.apiservice.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService{

    private final ApiRepository apiRepository;
    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper;


    @Override
    public void register(DeviceDTO deviceDTO) {

        DeviceVO deviceVO = modelMapper.map(deviceDTO, DeviceVO.class);

        deviceRepository.deviceInsert(deviceVO);

        apiRepository.updateDevicesCount(deviceDTO.getMemberNumber(),1);
    }
}
