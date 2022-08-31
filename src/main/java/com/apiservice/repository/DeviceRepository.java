package com.apiservice.repository;

import com.apiservice.model.DeviceDTO;
import com.apiservice.model.DeviceVO;
import com.apiservice.model.ListDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository {

    void deviceInsert(DeviceVO deviceVO);

    void deviceDelete(Integer serviceNumber);

    DeviceVO getPk(DeviceDTO deviceDTO); // device 테이블의 pk 와 member_number을 검사

    List<DeviceVO> selectList(ListDTO listDTO);

    int getTotal(ListDTO listDTO);


}
