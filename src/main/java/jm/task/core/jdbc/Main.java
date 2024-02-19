package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Проверяем соединение с базой данных
        boolean useHibernate = true;
        UserService userService = new UserServiceImpl(useHibernate);

        // Удаляем таблицу, если она существует
        userService.dropUsersTable();

        // Создаем и заполняем таблицу
        userService.createUsersTable();

        // Добавляем пользователя
        userService.saveUser("Иван", "Иванов", (byte) 30);
        userService.saveUser("Петр", "Петров", (byte) 25);
        userService.saveUser("Сергей", "Сергеев", (byte) 40);

        // Получаем всех пользователей из базы данных
        List<User> users = userService.getAllUsers();

        // Выводим информацию о каждом пользователе
        for (User user : users) {
            System.out.println(user);
        }

        // Очищаем таблицу пользователей
        userService.cleanUsersTable();

        // Удаляем таблицу
        userService.dropUsersTable();
    }
}