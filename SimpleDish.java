package com.makdon;

public class SimpleDish extends Dish {

    public SimpleDish(String name, int cost) {
        super(name, cost);
    }

    public void markAsReady(){
        setReady(true);
    }

}
