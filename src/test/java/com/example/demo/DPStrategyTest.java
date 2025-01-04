package com.example.demo;

import com.example.demo.model.DPStrategy;
import com.example.demo.model.Route;
import com.example.demo.model.Transfer;
import junit.framework.TestCase;

import java.util.ArrayList;

public class DPStrategyTest extends TestCase {
    private DPStrategy routeBuilder;

    public void setUp() {
        routeBuilder = new DPStrategy();
    }

    public void testSimple() {
        ArrayList<Transfer> transfers = new ArrayList<>();
        assertTrue(routeBuilder.buildRoute(0, transfers).isEmpty());
    }

    public void testShouldBeEmpty() {
        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(10, 1));
        transfers.add(new Transfer(10, 1));
        assertTrue(routeBuilder.buildRoute(9, transfers).isEmpty());
    }

    public void testOneLengthRoute() {
        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(1, 1));
        assert routeBuilder.buildRoute(1, transfers).size() == 1;
    }

    public void testGivenExample() {
        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(5, 10));
        transfers.add(new Transfer(10, 20));
        transfers.add(new Transfer(3, 5));
        transfers.add(new Transfer(8, 15));
        Route route = routeBuilder.buildRoute(15, transfers);
        assert route.getCost() == 30;
    }
}
