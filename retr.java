package org.mysqltutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mysqltutorial.org
 */
public class retr{

    public static void main(String[] args) {
        //
        String sql = "SELECT movie_name,actor_name,actress_name" +
                "FROM movietable1";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("movie_name") + "\t" +
                        rs.getString("actor_name")  + "\t" +
                        rs.getString("actress_name"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
