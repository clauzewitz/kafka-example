package com.clauzewitz.kafkaexample.vo.mapper;

import com.clauzewitz.kafkaexample.req.RecipeReq;
import com.clauzewitz.kafkaexample.vo.RecipeVO;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RecipeMapper {
    @Getter
    private static final ModelMapper mapper = new ModelMapper();

    @PostConstruct
    public void setupMapper() {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);

        mapper.createTypeMap(RecipeReq.class, RecipeVO.class)
                .addMappings(mapper -> {
                    mapper.map(s -> s.getName(), RecipeVO::setName);
                    mapper.map(s -> s.getIngredients(), RecipeVO::setIngredients);
                    mapper.map(s -> s.getCookingMethods(), RecipeVO::setCookingMethods);
                });
    }
}
