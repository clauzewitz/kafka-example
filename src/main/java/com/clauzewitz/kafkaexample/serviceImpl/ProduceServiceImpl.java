package com.clauzewitz.kafkaexample.serviceImpl;

import com.clauzewitz.kafkaexample.service.ProduceService;
import com.clauzewitz.kafkaexample.vo.CheifVO;
import com.clauzewitz.kafkaexample.vo.RecipeVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service(value = "produceService")
@RequiredArgsConstructor
public class ProduceServiceImpl implements ProduceService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    final KafkaTemplate<String, RecipeVO> kafkaTemplate;
    final KafkaTemplate<String, CheifVO> kafkaTemplate2;

    @Async
    public void produce(RecipeVO recipeVO) {
        ListenableFuture<SendResult<String, RecipeVO>> future = kafkaTemplate.send("kafka-example", recipeVO);

        future.addCallback(
                result -> logger.debug(((SendResult<String, RecipeVO>) result).getProducerRecord().value().toString()),
                ex -> logger.debug(ex.getMessage()));
    }

    @Async
    public void produce(CheifVO cheifVO) {
        ListenableFuture<SendResult<String, CheifVO>> future = kafkaTemplate2.send("kafka-example2", cheifVO);

        future.addCallback(
                result -> logger.debug(((SendResult<String, CheifVO>) result).getProducerRecord().value().toString()),
                ex -> logger.debug(ex.getMessage()));
    }
}
