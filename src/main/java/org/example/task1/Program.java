package org.example.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personClass = Class.forName("org.example.task1.Person");

        // Получить все поля
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Поле: " + field.getName());
        }

        // Получить список всех конструкторов
        Constructor[] constructors = personClass.getConstructors();

        // Создать экземпляр класса
        Object personInstance = constructors[0].newInstance(null);

        // Установить значения полей
        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(personInstance, "Alice");

        // Вызов метода
        Method displayMethodInfo = personClass.getDeclaredMethod("displayInfo");
        displayMethodInfo.invoke(personInstance);
    }
}
