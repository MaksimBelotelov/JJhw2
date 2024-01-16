package org.example.task2;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Employee user = new Employee("Maksim", "ftabitak@rambler.ru");
        UUID pk = UUID.randomUUID();

        QueryBuilder queryBuilder = new QueryBuilder();

        //Генерим SQL - запрос для вставки
        String insertQuery = queryBuilder.buildInsertQuery(user);
        System.out.println("Insert query: " + insertQuery);

        //Генерация SQL - запроса для выборки
        String selectQuery = queryBuilder.buildSelectQuery(Employee.class, pk);
        System.out.println("Select query: " + selectQuery);


        user.setEmail("test@gmail.com");
        //Генерация SQL - запроса для обновления
        String updateQuery = queryBuilder.buildUpdateQuery(user);
        System.out.println("Update query: " + updateQuery);

        //Генерация SQL - запроса для удаления
        String deleteQuery = queryBuilder.buildDeleteQuery(Employee.class, pk);
        System.out.println("Delete query: " + deleteQuery);
    }
}
