package com.example;

import java.util.List;

public class Lion extends Animal implements Kittens{ //добавил extends Animal implements Kittens

    boolean hasMane;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

 //   Feline feline = new Feline(); //создали объект Feline (Кошачий) //убираем зависимость от feline

    @Override //переопредилил из интерфейса Kittens
    public int getKittens() {
        //return feline.getKittens();
        return getKittens(1);
    }

    @Override //переопредилил из интерфейса Kittens
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        // return feline.getFood("Хищник"); //убираем зависимость от feline
        return getFood("Хищник"); //обратился к методу родителя - Animal
    }
}