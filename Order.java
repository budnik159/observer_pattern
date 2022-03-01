package com.makdon;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Order implements IClientOrder, IKitchenOrder {
    private final ArrayList<Dish> dishes = new ArrayList<>();
    private final String orderNumber;
    private ArrayList<IListener> listeners = new ArrayList<>();

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public void addMeal(Dish dish) {
        dishes.add(dish);
    }

    @Override
    public List<String> getReceiptInfo() {
        return dishes.stream().map(t -> t.getName() + " " + t.getCost() + "р.").collect(Collectors.toList());
    }

    @Override
    public void makeMealReady(String simpleDishName) {
        getSimpleMeals().stream().filter(t -> t.getName().equals(simpleDishName) && !t.isReady()).findFirst().
                ifPresent(t -> t.setReady(true));

        if (dishes.stream().allMatch(Dish::isReady)) {
            onOrderReady();
        }
    }

    @Override
    public List<SimpleDish> getSimpleMeals() {
        Stream<SimpleDish> r = dishes.stream().filter(t -> t instanceof ComboDish).flatMap(t -> ((ComboDish) t).getSimpleDishes().stream());
        Stream<SimpleDish> p = dishes.stream().filter(t -> t instanceof SimpleDish).map(t -> (SimpleDish)t);
        return Stream.concat(r, p).collect(Collectors.toList());

    }

    private void onOrderReady(){
        for (IListener listener : listeners) {
            listener.orderReady(orderNumber);
        }
    }

    @Override
    public void subscribe(IListener listener) {
        if (!listeners.contains(listener)){
            listeners.add(listener);
        }
    }

    @Override
    public void unSubscribe(IListener listener) {
        listeners.remove(listener);
    }
}
