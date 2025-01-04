package com.example.demo.model;

public class Transfer implements Component{
    private final int weight;
    private final int cost;

    public Transfer(int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }
}
