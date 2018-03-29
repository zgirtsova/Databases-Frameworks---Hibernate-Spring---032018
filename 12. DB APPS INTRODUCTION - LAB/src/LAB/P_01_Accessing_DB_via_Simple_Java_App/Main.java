package LAB.P_01_Accessing_DB_via_Simple_Java_App;

import java.sql.*;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);

        String URL = "jdbc:mysql://localhost:3306/soft_uni?createDatabaseIfNotExist=true";
        String USER = "root";
        String PASSWORD = "";

        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);

        Connection conn = DriverManager.getConnection(URL, props);

        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM employees WHERE salary > ?");
        String salary = sc.nextLine();
        stmt.setDouble(1, Double.parseDouble(salary));

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString(2) + " " + rs.getString(5));
        }


    }
}
