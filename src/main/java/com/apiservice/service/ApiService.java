package com.apiservice.service;

import com.apiservice.model.ApiDTO;
import com.apiservice.model.ListDTO;
import com.apiservice.model.ListResponseDTO;

import java.util.List;

public interface ApiService {

    void register(ApiDTO apiDTO);

    void update(ApiDTO apiDTO);

    void delete(Integer memberNumber);

    ListResponseDTO<ApiDTO> getList(ListDTO listDTO);



}
