package com.clauzewitz.kafkaexample.listner;

import com.clauzewitz.kafkaexample.prop.CheifProperties;
import com.clauzewitz.kafkaexample.prop.RecipeProperties;
import com.clauzewitz.kafkaexample.vo.CheifVO;
import com.clauzewitz.kafkaexample.vo.RecipeVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomKafkaListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @NonNull
    private RecipeProperties recipeProperties;

    @NonNull
    private CheifProperties cheifProperties;

    @KafkaListener(topics = "kafka-example", groupId = "json")
    public void listen(RecipeVO recipeVO) {
        logger.debug(String.format("topic: %s - %s", recipeProperties.getTopic(), recipeVO.toString()));
    }

    @KafkaListener(topics = "kafka-example2", groupId = "json")
    public void listen(CheifVO cheifVO) {
        logger.debug(String.format("topic: %s - %s", cheifProperties.getTopic(), cheifVO.toString()));
    }
}
