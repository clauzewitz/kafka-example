package com.clauzewitz.kafkaexample.vo;

import com.clauzewitz.kafkaexample.req.CheifReq;
import com.clauzewitz.kafkaexample.vo.mapper.CheifMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CheifVO {

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final ObjectMapper mapper = new ObjectMapper();

    @NonNull
    private String name;
    @NonNull
    private String cheif;
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
    public static CheifVO convertTemplateEntity(final CheifReq cheifReq) {
        return CheifMapper.getMapper().map(cheifReq, CheifVO.class);
    }

}
