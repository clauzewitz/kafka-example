package com.clauzewitz.kafkaexample.vo;

import com.clauzewitz.kafkaexample.req.RecipeReq;
import com.clauzewitz.kafkaexample.vo.mapper.RecipeMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RecipeVO {

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final ObjectMapper mapper = new ObjectMapper();

    @NonNull
    private String name;
    @NonNull
    private List<String> ingredients;
    @NonNull
    private List<String> cookingMethods;
    @Builder.Default
    private long cratedAt = System.currentTimeMillis();

    @Override
    @SuppressWarnings("finally")
    public String toString() {
        String result = null;

        try {
            result = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @JsonIgnore
    public static RecipeVO convertTemplateEntity(final RecipeReq recipeReq) {
        return RecipeMapper.getMapper().map(recipeReq, RecipeVO.class);
    }

}
