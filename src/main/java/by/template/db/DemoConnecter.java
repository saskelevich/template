package by.template.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoConnecter {

    private static final String PASSWORD = "1";
    private static final String USER = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/saskel-cars"; // change name
                                                                                      // db

    public static void main(final String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM car");) {

            while (resultSet.next()) {
                System.out.printf("%s|%s|%s\n", resultSet.getInt("id"), resultSet.getString("vin"),
                        resultSet.getDate("created"));
            }
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }
}
