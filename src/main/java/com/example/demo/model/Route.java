package com.example.demo.model;

import java.util.ArrayList;

public class Route extends ArrayList<Component> implements Component {
    public int getCost() {
        int cost = 0;
        for(Component transfer : this) {
            cost += transfer.getCost();
        }
        return cost;
    }
}
