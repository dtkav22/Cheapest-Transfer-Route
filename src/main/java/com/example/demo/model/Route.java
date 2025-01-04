package com.example.demo.model;

import java.util.ArrayList;

public class Route extends ArrayList<Component> implements Component {
    public int getCost() {
        int cost = 0;
        for(Component elem : this) {
            cost += elem.getCost();
        }
        return cost;
    }

    public int getWeight() {
        int weight = 0;
        for(Component elem : this) {
            weight += elem.getWeight();
        }
        return weight;
    }
}
