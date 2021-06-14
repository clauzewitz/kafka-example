package com.clauzewitz.kafkaexample.controller;

import com.clauzewitz.kafkaexample.handler.exception.BadRequestException;
import com.clauzewitz.kafkaexample.req.CheifReq;
import com.clauzewitz.kafkaexample.req.RecipeReq;
import com.clauzewitz.kafkaexample.service.ProduceService;
import com.clauzewitz.kafkaexample.vo.CheifVO;
import com.clauzewitz.kafkaexample.vo.RecipeVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/produce")
@RestController(value = "demoController")
@RequiredArgsConstructor
public class DemoController {

    @NonNull
    final ProduceService produceService;

    @PostMapping(path = "/recipe")
    public ResponseEntity<Void> produce(@RequestBody RecipeReq recipeReq) {

        if (ObjectUtils.isEmpty(recipeReq)) {
            throw new BadRequestException();
        }

        produceService.produce(RecipeVO.convertTemplateEntity(recipeReq));
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/cheif")
    public ResponseEntity<Void> produce2(@RequestBody CheifReq cheifReq) {

        if (ObjectUtils.isEmpty(cheifReq)) {
            throw new BadRequestException();
        }

        produceService.produce(CheifVO.convertTemplateEntity(cheifReq));
        return ResponseEntity.ok().build();
    }

}
