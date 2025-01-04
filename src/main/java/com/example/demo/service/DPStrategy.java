package com.example.demo.service;

import com.example.demo.model.Route;
import com.example.demo.model.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DPStrategy implements RouteBuilderStrategy {

    private boolean[][] findCheapestRoute(int maxWeight, List<Transfer> availableTransfers) {
        int numberOfTransfers = availableTransfers.size();
        if(numberOfTransfers == 0)
            return null;
        int[][] dpCost = new int[numberOfTransfers][maxWeight + 1];
        boolean[][] dpRoute = new boolean[numberOfTransfers][maxWeight + 1];

        for(int w = 0; w <= maxWeight; w++) {
            if(availableTransfers.getFirst().getWeight() <= w) {
                dpRoute[0][w] = true;
                dpCost[0][w] = availableTransfers.getFirst().getCost();
            } else {
                dpRoute[0][w] = false;
                dpCost[0][w] = 0;
            }
        }

        for(int i = 1; i < numberOfTransfers; i++) {
            Transfer transfer = availableTransfers.get(i);
            int cost = transfer.getCost();
            for(int w = 0; w <= maxWeight; w++) {
                if(transfer.getWeight() <= w && dpCost[i - 1][w] < cost + dpCost[i - 1][w - transfer.getWeight()]) {
                    dpCost[i][w] = cost + dpCost[i - 1][w - transfer.getWeight()];
                    dpRoute[i][w] = true;
                } else {
                    dpCost[i][w] = dpCost[i - 1][w];
                    dpRoute[i][w] = false;
                }
            }
        }
        return dpRoute;
    }
    @Override
    public Route buildRoute(int maxWeight, List<Transfer> availableTransfers) {
        boolean[][] routeInfo = findCheapestRoute(maxWeight, availableTransfers);
        int weight = maxWeight;
        Route route = new Route();
        for(int i = availableTransfers.size() - 1; i >= 0; i--) {
            if(routeInfo[i][weight]) {
                route.add(availableTransfers.get(i));
                weight -= availableTransfers.get(i).getWeight();
            }
        }
        return route;
    }
}
