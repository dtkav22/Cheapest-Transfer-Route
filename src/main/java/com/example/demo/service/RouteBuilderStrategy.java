package com.example.demo.service;

import com.example.demo.model.Route;
import com.example.demo.model.Transfer;

import java.util.List;

public interface RouteBuilderStrategy {
    public Route buildRoute(int maxWeight, List<Transfer> availableTransfers);
}
