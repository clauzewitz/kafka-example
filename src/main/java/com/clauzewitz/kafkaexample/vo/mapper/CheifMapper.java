package com.clauzewitz.kafkaexample.vo.mapper;

import com.clauzewitz.kafkaexample.req.CheifReq;
import com.clauzewitz.kafkaexample.vo.CheifVO;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CheifMapper {
    @Getter
    private static final ModelMapper mapper = new ModelMapper();

    @PostConstruct
    public void setupMapper() {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);

        mapper.createTypeMap(CheifReq.class, CheifVO.class)
                .addMappings(mapper -> {
                    mapper.map(s -> s.getName(), CheifVO::setName);
                    mapper.map(s -> s.getCheif(), CheifVO::setCheif);
                });
    }
}
