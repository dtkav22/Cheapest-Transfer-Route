package com.example.demo.service;

import com.example.demo.model.Route;
import com.example.demo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private DPStrategy dpStrategy;

    @Autowired
    public RecursionStrategy recursionStrategy;

    public Route getRoute(int maxWeight, ArrayList<Transfer> availableTransfers) {
        int numberOfTransfers = availableTransfers.size();
        RouteBuilderStrategy strategy = dpStrategy;
        if(numberOfTransfers < 32 && numberOfTransfers * maxWeight > (1 << numberOfTransfers)){
            strategy = recursionStrategy;
            System.out.println("recursion");
        }
        return strategy.buildRoute(maxWeight, availableTransfers);
    }
}
