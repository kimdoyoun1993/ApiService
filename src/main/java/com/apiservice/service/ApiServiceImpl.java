package com.apiservice.service;

import com.apiservice.controller.Handler.CustomException;
import com.apiservice.model.ApiDTO;
import com.apiservice.model.ApiVO;
import com.apiservice.model.Error.ErrorCode;
import com.apiservice.model.ListDTO;
import com.apiservice.model.ListResponseDTO;
import com.apiservice.repository.ApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final ApiRepository apiRepository;
    private final ModelMapper modelMapper;

    @Override
    public void register(ApiDTO apiDTO) {

        log.info("service insert");
        log.info(apiDTO);

        //광고 수신 값이 null 이면 N 이 기본값으로 들어가게
        String advert = apiDTO.getAdvert() == null ? "N" :apiDTO.getAdvert();
        apiDTO.setAdvert(advert);

        //DB 조회 (중복 ID 가 있는지 검사)
        List<ApiVO> getApiVO = apiRepository.getCheck(apiDTO);

        if (getApiVO != null){
            log.info("ID 중복");
            throw new CustomException(ErrorCode.BAD_ARTICLE);
        }

        apiRepository.insert(apiDTO);

    }

    @Override
    public void update(ApiDTO apiDTO) {
        log.info("update service");
        log.info(apiDTO);

        //DB 조회 (PK 가 있는지 검사)
        List<ApiVO> getApiVO = apiRepository.getCheck(apiDTO);

        if(getApiVO == null){
            log.info("없는 PK 입니다");
            throw new CustomException(ErrorCode.NOT_INFO);
        }


        apiRepository.update(apiDTO);
    }

    @Override
    public void delete(Integer memberNumber) {
        log.info("delete service");
        log.info(memberNumber);

        apiRepository.delete(memberNumber);
    }

    @Override
    public ListResponseDTO<ApiDTO> getList(ListDTO listDTO) {

        List<ApiVO> apiList = apiRepository.selectList(listDTO);

        //apiVO 를 ApiDTO타입의 객체로 맵핑
        List<ApiDTO> dtoList =
                apiList.stream().map(apiVO -> modelMapper.map(apiVO,ApiDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<ApiDTO>builder()
                .dtoList(dtoList)
                .total(apiRepository.getTotal(listDTO))
                .build();
    }
}
