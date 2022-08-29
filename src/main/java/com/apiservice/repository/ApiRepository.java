package com.apiservice.repository;

import com.apiservice.model.ApiDTO;
import com.apiservice.model.ApiVO;
import com.apiservice.model.ListDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiRepository {

    void insert(ApiDTO apiDTO);

    void update(ApiDTO apiDTO);

    void delete(Integer memberNumber);

    List<ApiVO>selectList(ListDTO listDTO);

    int getTotal(ListDTO listDTO);

    List<ApiVO> getCheck(ApiDTO apiDTO);


}
