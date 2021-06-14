package com.clauzewitz.kafkaexample.service;

import com.clauzewitz.kafkaexample.vo.CheifVO;
import com.clauzewitz.kafkaexample.vo.RecipeVO;

public interface ProduceService {
    public void produce(RecipeVO recipeVO);
    public void produce(CheifVO cheifVO);
}
