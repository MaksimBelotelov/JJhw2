package org.example.hw;

public class Cat extends Animal{
    boolean isCatchingMouse;

    public Cat(String name, int age, boolean isCatchingMouse) {
        super(name, age);
        this.isCatchingMouse = isCatchingMouse;
    }

    @Override
    void makeSound() {
        System.out.println("Мяу - мяу");
    }
}
