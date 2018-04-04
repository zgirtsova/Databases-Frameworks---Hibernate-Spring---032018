import connector.Connector;
import constants.SQLCreateTables;
import constants.SQLTestData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class P01_The_Easy_Way {
    public static void main(String[] args) throws SQLException {

        Connector.initConnection("mysql", "root", "", "localhost", "3306", "minionsdb");
        Connection conn = Connector.getConn();

        String createTowns = SQLCreateTables.CREATE_TABLE_TOWNS;
        String createMinions = SQLCreateTables.CREATE_TABLE_MINIONS;
        String createVillains = SQLCreateTables.CREATE_TABLE_VILLAINS;
        String createMinionsVillains = SQLCreateTables.CREATE_TABLE_MINIONS_VILLAINS;
        String insertTowns = SQLTestData.INSERT_INTO_TOWNS;
        String insertMinions = SQLTestData.INSERT_INTO_MINIONS;
        String insertVillains = SQLTestData.INSERT_INTO_VILLAINS;
        String insertMinionsVillains = SQLTestData.INSERT_INTO_MINIONS_VILLAINS;

        // We execute statements one by one here


        PreparedStatement prstm = conn.prepareStatement(insertMinionsVillains);
        prstm.executeUpdate();

//        With resultSet we do this:
//
//        while (rs.next()) {
//            Date a = rs.getDate(2);
//            System.out.println(a);
//            String stop = "";
//        }

//        rs.close();

        prstm.closeOnCompletion();
        conn.close();

    }

}
