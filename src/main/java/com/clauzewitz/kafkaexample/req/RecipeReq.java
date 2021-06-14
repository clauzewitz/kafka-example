package com.clauzewitz.kafkaexample.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class RecipeReq {

    @NonNull
    private String name;
    @NonNull
    private List<String> ingredients;
    @NonNull
    private List<String> cookingMethods;

}
