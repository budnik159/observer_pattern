package com.makdon;


public abstract class Dish {
    private String name;
    private int cost;
    protected boolean isReady;

    public Dish(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    protected void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isReady() {
        return isReady;
    }
}
