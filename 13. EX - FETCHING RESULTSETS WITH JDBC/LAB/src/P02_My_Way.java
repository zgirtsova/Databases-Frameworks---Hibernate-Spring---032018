import connector.Connector;
import constants.Constants;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class P02_My_Way {
    public static void main(String[] args) throws SQLException {

        Connector.initConnection("mysql", "root", "", "localhost", "3306", "minionsdb");
        Connection conn = Connector.getConn();
        Statement pr = conn.createStatement();

        String SELECT_VILLAINS_WITH_MORE_THAN_THREE_MINIONS = String.format(
                "" +
                        "SELECT%n" +
                        "    *%n" +
                        "FROM%n" +
                        "    (SELECT%n" +
                        "        v.name AS 'villain', COUNT(mv.minion_id) AS 'minions'%n" +
                        "    FROM%n" +
                        "        `%s` AS v%n" +
                        "    JOIN `%s` AS mv ON v.id = mv.villain_id%n" +
                        "    GROUP BY v.id%n" +
                        "    ORDER BY `minions` DESC) AS vm%n" +
                        "WHERE%n" +
                        "    vm.minions >= 3",
                Constants.TABLE_VILLAINS, Constants.TABLE_MINIONS_VILLAINS);

        ResultSet rs = pr.executeQuery(SELECT_VILLAINS_WITH_MORE_THAN_THREE_MINIONS);
        ResultSetMetaData rsm = rs.getMetaData();
        int cCount = rsm.getColumnCount();

        while (rs.next()) {
            Map<String, Object> resultMap = new HashMap<>();

            //for (int i = 1; i <= cCount; i++) {
                //String columnName = rsm.getColumnName(i);
                //Object value = rs.getObject(i);
                //resultMap.put(columnName, value);
                String name = rs.getString(1);
                int nums = rs.getInt(2);
                System.out.println(name + " " + nums);
            //}
            //System.out.println(resultMap);
        }

        rs.close();

        pr.closeOnCompletion();
        conn.close();

    }
}
