package com.example.demo;

import com.example.demo.service.DPStrategy;
import com.example.demo.service.RecursionStrategy;
import com.example.demo.service.RouteBuilderStrategy;
import com.example.demo.model.Transfer;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Random;

public class RouteBuilderStrategyTest extends TestCase {
    private RouteBuilderStrategy dpRouteBuilder;
    private RouteBuilderStrategy recursionRouteBuilder;

    public void setUp() {
        dpRouteBuilder = new DPStrategy();
        recursionRouteBuilder = new RecursionStrategy();
    }

    public void testSimple() {
        ArrayList<Transfer> transfers = new ArrayList<>();
        assertTrue(dpRouteBuilder.buildRoute(0, transfers).isEmpty());
        assertTrue(recursionRouteBuilder.buildRoute(0, transfers).isEmpty());
    }

    public void testShouldBeEmpty() {
        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(10, 1));
        transfers.add(new Transfer(10, 1));
        assertTrue(dpRouteBuilder.buildRoute(9, transfers).isEmpty());
        assertTrue(recursionRouteBuilder.buildRoute(9, transfers).isEmpty());
    }

    public void testOneLengthRoute() {
        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(1, 1));
        assert dpRouteBuilder.buildRoute(1, transfers).size() == 1;
        assert recursionRouteBuilder.buildRoute(1, transfers).size() == 1;
    }

    public void testShouldTakeAll() {
        ArrayList<Transfer> transfers = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            transfers.add(new Transfer(1, 10));
        }
        assert dpRouteBuilder.buildRoute(10, transfers).getCost() == 100;
        assert recursionRouteBuilder.buildRoute(10, transfers).getCost() == 100;
    }

    public void testGivenExample() {
        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(5, 10));
        transfers.add(new Transfer(10, 20));
        transfers.add(new Transfer(3, 5));
        transfers.add(new Transfer(8, 15));
        assert dpRouteBuilder.buildRoute(15, transfers).getCost() == 30;
        assert recursionRouteBuilder.buildRoute(15, transfers).getCost() == 30;
    }

    public void testSameAnswerReturned() {
        Random rand = new Random();
        ArrayList<Transfer> transfers = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            transfers.add(new Transfer(rand.nextInt(10000), rand.nextInt(100000)));
        }
        int maxWeight = rand.nextInt(200000);
        assert dpRouteBuilder.buildRoute(maxWeight, transfers).getCost() == recursionRouteBuilder.buildRoute(maxWeight, transfers).getCost();
        assert dpRouteBuilder.buildRoute(maxWeight, transfers).getWeight() == recursionRouteBuilder.buildRoute(maxWeight, transfers).getWeight();
    }
}
