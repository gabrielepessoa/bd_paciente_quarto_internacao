package infraestrutura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    private String userName = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/abrace_um_pet";
    private Connection conn = null;

    public DAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn = DriverManager.getConnection(this.url, this.userName,
                    this.password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public void executeSql(String sql) {
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeResultSetSql(String sql) {
        ResultSet result = null;
        try {
            Statement s = conn.createStatement();
            result = s.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
