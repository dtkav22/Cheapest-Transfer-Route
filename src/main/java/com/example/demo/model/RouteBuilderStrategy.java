package com.example.demo.model;

import java.util.List;

public interface RouteBuilderStrategy {
    public Route buildRoute(int maxWeight, List<Transfer> availableTransfers);
}
