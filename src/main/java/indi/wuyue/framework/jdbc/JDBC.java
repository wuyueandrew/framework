package indi.wuyue.framework.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JDBC {

    private final static Logger LOGGER = LoggerFactory.getLogger(JDBC.class);


    /**
     * 实际上读对事务没有影响
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "";
        String username = "";
        String password = "";
        String sql = "SHOW TABLES ";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                LOGGER.info(rs.getString(1));
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }
    }

}
