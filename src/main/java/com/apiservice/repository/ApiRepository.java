package com.apiservice.repository;

import com.apiservice.model.ApiDTO;
import com.apiservice.model.ApiVO;
import com.apiservice.model.ListDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiRepository {

    void insert(ApiDTO apiDTO);

    void update(ApiDTO apiDTO);

    void delete(Integer memberNumber);

    List<ApiVO>selectList(ListDTO listDTO);

    int getTotal(ListDTO listDTO);

    ApiVO getPk(ApiDTO apiDTO); // api 테이블 pk

    ApiVO getId(ApiDTO apiDTO); // api 테이블 memberId


    void updateDevicesCount(@Param("memberNumber") Integer memberNumber, @Param("amount") int amount);

    void deleteDevicesCount(@Param("memberNumber") Integer memberNumber);



}
