package LAB.P_02_Writing_Your_Dwn_Data_Retrieval_Application;

import java.sql.*;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "");

        Connection conn = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/diablo?createDatabaseIfNotExist=true", props);

        System.out.println("Enter username to retrieve info: ");
        String username = sc.nextLine();

        PreparedStatement stmt = conn.prepareStatement(
                "SELECT u.user_name, u.first_name, u.last_name, COUNT(ug.id)\n" +
                        "FROM users AS u\n" +
                        "JOIN users_games AS ug\n" +
                        "ON u.id = ug.user_id\n" +
                        "WHERE u.user_name = ?\n" +
                        "GROUP BY u.user_name\n");
        stmt.setString(1, username);

        ResultSet rs = stmt.executeQuery();

        if (rs == null) {
            System.out.println("No such user exists");
            return;
        }

        while(rs.next()) {
            System.out.println("User: " + username);
            System.out.println(rs.getString(2) + " " + rs.getString(3) +
                    " has played " + rs.getInt(4) + " games");
        }
    }
}
