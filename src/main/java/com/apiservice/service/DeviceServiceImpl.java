package com.apiservice.service;


import com.apiservice.controller.Handler.CustomException;
import com.apiservice.model.*;
import com.apiservice.model.Error.ErrorCode;
import com.apiservice.repository.ApiRepository;
import com.apiservice.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService{

    private final ApiRepository apiRepository;
    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper;



    @Override
    public void register(DeviceDTO deviceDTO , ApiDTO apiDTO) {

        DeviceVO deviceVO = modelMapper.map(deviceDTO, DeviceVO.class);


        deviceRepository.deviceInsert(deviceVO);

        //api<고객> 테이블 에 존재하는 PK 인지 확인
        if(apiRepository.getPk(apiDTO) ==null){
            log.info("ErrorCode NOT_INFO");
            throw new CustomException(ErrorCode.NOT_INFO);
        }

        apiRepository.updateDevicesCount(deviceDTO.getMemberNumber(),1);


    }

    @Override
    public void delete(Integer serviceNumber , DeviceDTO deviceDTO) {

        //유효성 검사와 member_number을 매칭하기 위한 select
        DeviceVO getPk = deviceRepository.getPk(deviceDTO);

        //존재 안 하는 장치는 삭제할 수 없다
        if(getPk == null){
            throw new CustomException(ErrorCode.NOT_INFO);
        }

        log.info("deviceDelete");
        deviceRepository.deviceDelete(serviceNumber);

        apiRepository.deleteDevicesCount(getPk.getMemberNumber());

    }

    @Override
    public ListResponseDTO<DeviceDTO> getList(ListDTO listDTO) {

        List<DeviceVO> apiList = deviceRepository.selectList(listDTO);


        //deviceVO 를 DeviceDTO 타입의 객체로 맵핑
        List<DeviceDTO> dtoList =
                apiList.stream().map(deviceVO -> modelMapper.map(deviceVO,DeviceDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<DeviceDTO>builder()
                .dtoList(dtoList)
                .total(deviceRepository.getTotal(listDTO))
                .build();
    }
}
