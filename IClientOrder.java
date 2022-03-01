package com.makdon;

import java.util.ArrayList;
import java.util.List;

public interface IClientOrder {

    void addMeal(Dish dish);
    List<String> getReceiptInfo();
    void subscribe(IListener listener);
    void unSubscribe(IListener listener);

}
