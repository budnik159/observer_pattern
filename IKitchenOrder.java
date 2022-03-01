package com.makdon;

import java.util.ArrayList;
import java.util.List;

public interface IKitchenOrder {

    void makeMealReady(String simpleDishName);
    List<SimpleDish> getSimpleMeals();
}
