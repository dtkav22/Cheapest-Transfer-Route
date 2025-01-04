package com.example.demo.model;

import java.util.List;

public class RecursionStrategy implements RouteBuilderStrategy {

    private Route recursion(int weightLeft, List<Transfer> availableTransfers, Route routeNow, int transferIndex) {
        if(transferIndex == availableTransfers.size())
            return (Route) routeNow.clone();

        Route routeWithoutThisTransfer = recursion(weightLeft, availableTransfers, routeNow, transferIndex + 1);
        Route routeWithThisTransfer = null;
        int w = availableTransfers.get(transferIndex).getWeight();

        if(w <= weightLeft){
            routeNow.add(availableTransfers.get(transferIndex));
            routeWithThisTransfer = recursion(weightLeft - w, availableTransfers, routeNow, transferIndex + 1);
            routeNow.removeLast();
        } else
            return routeWithoutThisTransfer;

        if(routeWithThisTransfer.getCost() <= routeWithoutThisTransfer.getCost())
            return routeWithoutThisTransfer;

        return routeWithThisTransfer;
    }
    @Override
    public Route buildRoute(int maxWeight, List<Transfer> availableTransfers) {
        return recursion(maxWeight, availableTransfers, new Route(), 0);
    }
}
