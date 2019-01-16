package com.kodilla.good.paterns.challenges.Food2Door;

import java.util.Map;

public interface Producent {

    void process(OrderRequest orderRequest);

    Map<String, Integer> productsList();

}
