package week6.JDBC;

import java.sql.*;

public class JDBC {
    private static final String URL = "jdbc:postgresql://localhost:5432/university";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        Connection conn = null;
        String selectSql = "SELECT * FROM employees";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement statement = conn.createStatement();
            ResultSet data = statement.executeQuery(selectSql);
            while (data.next()){
                System.out.println("Employee id = " + data.getInt("id"));
                System.out.println("Employee name = " +data.getString("full_name"));
                System.out.println("Employee position = " +data.getString("position"));
                System.out.println("Employee salary = " +data.getInt("salary"));
                System.out.println("--------------------");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
