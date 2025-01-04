package com.example.demo;

import com.example.demo.model.Route;
import com.example.demo.model.Transfer;
import junit.framework.TestCase;

public class RouteTest extends TestCase {
    public void testSimple() {
        assert new Route().getCost() == 0;
        assert new Route().getWeight() == 0;
    }

    public void testTransfersRoute() {
        Route route = new Route();
        route.add(new Transfer(1, 10));
        route.add(new Transfer(2, 15));
        assert route.getCost() == 25;
        assert  route.getWeight() == 3;
    }

    public void testComposedRoute() {
        Route route = new Route();
        Route firstRoute = new Route();
        firstRoute.add(new Transfer(1, 10));
        firstRoute.add(new Transfer(2, 15));
        route.add(firstRoute);
        route.add(new Route());
        route.add(new Transfer(3, 1));
        assert route.getCost() == 26;
        assert route.getWeight() == 6;
    }
}
