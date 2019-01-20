package com.kodilla.good.patterns.challenges.food2Door;

import java.util.Map;

public interface Producent {

    void process(OrderRequest orderRequest);

    Map<String, Integer> productsList();

}
