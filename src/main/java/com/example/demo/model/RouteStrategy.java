package com.example.demo.model;

import java.util.List;

public interface RouteStrategy {
    public Route buildRoute(int maxWeight, List<Transfer> availableTransfers);
}
