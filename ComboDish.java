package com.makdon;

import java.util.ArrayList;
import java.util.List;

public class ComboDish extends Dish {
    private List<SimpleDish> simpleDishes;

    public ComboDish(String name, int cost) {
        super(name, cost);

        simpleDishes = new ArrayList<>();
    }

    @Override
    public boolean isReady() {
        return simpleDishes.stream().allMatch(SimpleDish::isReady);
    }

    public List<SimpleDish> getSimpleDishes() {
        return simpleDishes;
    }
    public void setSimpleDishes(List<SimpleDish> simpleDishes) {
        this.simpleDishes = simpleDishes;
    }
}
