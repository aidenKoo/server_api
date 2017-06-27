/**
 * Created by aiden on 2017-06-16.
 */

public class DBConnection extends Application {

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

    public class DBConnection {
        private String DB_URL = "Jdbc:Odbc:perfectground";
        private String DB_USER = "root";
        private String DB_PASSWORD= "toor";

        Connection conn = null;

        public Connection getConnection() {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }

            try {
                Properties props = new Properties();
                props.put("charSet", "8859_1" );
                props.put("user", DB_USER);
                props.put("password", DB_PASSWORD);

                conn = DriverManager.getConnection(DB_URL, props);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
        public static void main (string [] args){
            DBConnection dbConn = new DBConnection();
            Connection conn = null;
            PreparedStatement psmt = null;
            ResultSet rs = null;

            try{
                String sql = " SELECT member_ID FROM member_info ";
                conn = dbConn.getConnection();
                psmt = conn.prepareStatement(sql);

                rs = psmt.executeQuery();

                while (rs.next()) {
                    String username = new String(rs.getString("member_ID").getBytes("8859_1"), "euc-kr");
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                dbConn.disConnection(rs,psmt, conn);
            }
            System.out.println(username);
        }
    }
}
