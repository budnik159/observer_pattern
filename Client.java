package com.makdon;

public class Client implements IListener{

    String name;

    public Client(String name){
        this.name = name;
    }

    @Override
    public void orderReady(String orderNumber) {
        System.out.println("Клиент " + name + " оповещен о готовности заказа номер " + orderNumber);
    }

}
