package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {

    private final Connection connection = getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "create table users\n" +
                "(\n" +
                "\tid int auto_increment,\n" +
                "\tname varchar(45) not null,\n" +
                "\tlastName varchar(45) not null,\n" +
                "\tage int not null,\n" +
                "\tconstraint users_pk\n" +
                "\t\tprimary key (id)\n" + ")";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try {
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLSyntaxErrorException s) {
                System.err.println("Создание не возможно. Таблица с таким наименованием уже существует.");
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() throws SQLException {
        String sql = "drop table users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try {
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLSyntaxErrorException s) {
                System.err.println("Удаление не возможно. Таблица с таким наименованием не существует.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {

        String sql = "insert into users (name, lastName, age) values(?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("User с именем – " + name + " добавлен в базу данных");

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    public void removeUserById(long id) throws SQLException {

        String sql = "delete from users where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    public List<User> getAllUsers() {
        String sql = "select * from users";
        List<User> list = new LinkedList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            connection.commit();

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString(2));
                user.setId(resultSet.getLong(1));
                user.setAge(resultSet.getByte(4));
                user.setLastName(resultSet.getString(3));

                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() throws SQLException {
        String sql = "delete from users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();

        }
    }
}
