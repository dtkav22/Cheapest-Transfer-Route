package com.example.demo;

import com.example.demo.model.Route;
import com.example.demo.model.Transfer;
import junit.framework.TestCase;

public class RouteTest extends TestCase {
    public void testSimple() {
        assert new Route().getCost() == 0;
    }

    public void testTransfersRoute() {
        Route route = new Route();
        route.add(new Transfer(0, 10));
        route.add(new Transfer(0, 15));
        assert route.getCost() == 25;
    }

    public void testComposedRoute() {
        Route route = new Route();
        Route firstRoute = new Route();
        firstRoute.add(new Transfer(0, 10));
        firstRoute.add(new Transfer(0, 15));
        route.add(firstRoute);
        route.add(new Route());
        route.add(new Transfer(0, 1));
        assert route.getCost() == 26;
    }
}
