package com.makdon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// паттерн Наблюдатель
public class Main {
    public static void main(String[] args) {

        IListener firstClient = new Client("Волков Иван");

        IListener secondClient = new IListener() {
            @Override
            public void orderReady(String orderNumber) {
                System.out.println("Робот " +  " оповещен о готовности заказа номер " + orderNumber);

            }
        };

        IListener thirdClient = orderNumber -> System.out.println("Анонимный клиент извещен о готовности заказа номер " + orderNumber);

        Order firstOrder = new Order("A1");
        firstOrder.subscribe(firstClient);
        firstOrder.subscribe(secondClient);
        firstOrder.subscribe(thirdClient);

        SimpleDish simpleDish1 = new SimpleDish("Борщ", 50);
        SimpleDish simpleDish2 = new SimpleDish("Яичница", 40);
        SimpleDish simpleDish3 = new SimpleDish("Каша рисовая", 30);
        SimpleDish simpleDish4 = new SimpleDish("Стакан молока", 20);
        SimpleDish simpleDish5 = new SimpleDish("Кусок хлеба с маслом", 10);
        ComboDish comboDish = new ComboDish("Деревенский завтрак", 100);

        List<SimpleDish> simpleDishList = new ArrayList<>();
        Collections.addAll(simpleDishList, simpleDish2, simpleDish3, simpleDish4, simpleDish5);
        comboDish.setSimpleDishes(simpleDishList);

        firstOrder.addMeal(simpleDish1);
        firstOrder.addMeal(comboDish);

        for (Dish dish : firstOrder.getSimpleMeals()) {
            System.out.println(dish.getName());
            firstOrder.makeMealReady(dish.getName());
        }

    }
}
