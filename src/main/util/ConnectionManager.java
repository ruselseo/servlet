package main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private ConnectionManager() {}

    private static String URL = "db_url";
    private static String USER = "db_user";
    private static String PASSWORD = "db_password";

    public static Connection get() throws SQLException {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL),
                    PropertiesUtil.get(USER),
                    PropertiesUtil.get(PASSWORD));
        }catch (SQLException throwable) {
            throw new RuntimeException(throwable);}
    }


}
