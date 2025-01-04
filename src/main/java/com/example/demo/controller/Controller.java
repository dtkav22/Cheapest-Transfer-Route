package com.example.demo.controller;

import com.example.demo.model.Route;
import com.example.demo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.Service;

import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    private Service service;

    private static class RouteRequest {
        private int maxWeight;
        private ArrayList<Transfer> availableTransfers;

        public int getMaxWeight() {
            return maxWeight;
        }

        public ArrayList<Transfer> getAvailableTransfers() {
            return availableTransfers;
        }
    }

    private static class RouteResponse {
        private final Transfer[] selectedTransfers;
        private final int totalCost;
        private final int totalWeight;

        public RouteResponse(Transfer[] selectedTransfers, int totalWeight, int totalCost) {
            this.selectedTransfers = selectedTransfers;
            this.totalWeight = totalWeight;
            this.totalCost = totalCost;
        }

        public int getTotalCost() {
            return totalCost;
        }

        public Transfer[] getSelectedTransfers() {
            return selectedTransfers;
        }

        public int getTotalWeight() {
            return totalWeight;
        }
    }

    @PostMapping("/getRoute")
    @ResponseBody
    public RouteResponse getRoute(@RequestBody RouteRequest request) {
        Route route = service.getRoute(request.getMaxWeight(), request.getAvailableTransfers());
        RouteResponse response = new RouteResponse(route.toArray(new Transfer[0]), route.getWeight(), route.getCost());
        return response;
    }
}
