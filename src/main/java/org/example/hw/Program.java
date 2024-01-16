package org.example.hw;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Animal[] animals = new Animal[4];
        animals[0] = new Cat("Васька", 2, false);
        animals[1] = new Dog("Мухтар", 5, "Овчарка");
        animals[2] = new Cat("Мурка", 4, true);
        animals[3] = new Dog("Полкан", 1, "Болонка");

        for(Animal animal : animals) {
            Class<?> clazz = animal.getClass();
            System.out.printf("Животное: %s\n", clazz.getSimpleName().equals("Cat") ? "Кошка" : "Собака");

            Field nameField = clazz.getSuperclass().getDeclaredField("name");
            nameField.setAccessible(true);
            System.out.printf("Кличка: %s\n", nameField.get(animal));

            Field ageField = clazz.getSuperclass().getDeclaredField("age");
            ageField.setAccessible(true);
            System.out.printf("Возраст: %s\n", ageField.get(animal));

            Field unicumField;

            if(clazz.getSimpleName().equals("Cat")) {
                System.out.print("Ловит мышей: ");
                unicumField = clazz.getDeclaredField("isCatchingMouse");
            }
            else {
                System.out.print("Порода: ");
                unicumField = clazz.getDeclaredField("breed");
            }
            unicumField.setAccessible(true);
            System.out.println(unicumField.get(animal));

            try {
                Method soundMethod = clazz.getDeclaredMethod("makeSound");
                System.out.println("Голос: ");
                soundMethod.invoke(animal);
            }
            catch (NoSuchMethodException ex) {
                System.out.println("Я не издаю звуков");
            }
            System.out.println("-------------------------------------------");
        }
    }
}
