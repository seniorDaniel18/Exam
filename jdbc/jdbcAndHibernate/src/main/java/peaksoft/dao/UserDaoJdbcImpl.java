package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {

        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(30)," +
                "lastName VARCHAR(30)," +
                "age INT" +
                ");";

        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("create table success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {

        String dropSql = "DROP TABLE users";

        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropSql);
            System.out.println("drop table success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        String saveSql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";

        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveSql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("Successfully added " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {

        String removeSql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(removeSql)) {
            preparedStatement.setInt(1, (int) id);
            preparedStatement.executeUpdate();
            System.out.println("remove success");
        } catch (SQLException e) {

        }
    }

    public List<User> getAllUsers() {

        String sql = "SELECT * FROM users ";
        List<User> userList = new ArrayList<>();

        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                User user = new User();

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                int age = resultSet.getInt("age");

                user.setId((long) id);
                user.setName(name);
                user.setLastName(lastName);
                user.setAge((byte) age);

                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public void cleanUsersTable() {

        String cleanSql = "TRUNCATE users";

        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(cleanSql);
            System.out.println("clean success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}