package OLS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper
{

    private static final String URL = "jdbc:sqlserver://your-server:1433;databaseName=your_db";
    private static final String USER = "your_user";
    private static final String PASSWORD = "your_password";

    public static void executeQuery(String sqlQuery)
    {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement())
        {

            boolean isResultSet = statement.execute(sqlQuery);

            if (isResultSet)
            {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next())
                {
                    System.out.println("Результат: " + resultSet.getString(1)); // Вывести данные
                }
            } else
            {
                System.out.println("Запрос выполнен успешно.");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
