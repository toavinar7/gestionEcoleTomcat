package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class BaseDao {
    public Connection getConn() throws Exception {
        Connection connection;
        try {
            Class.forName(Config.getPropertyValue("driverClassName"));
            String url = Config.getPropertyValue("url");
            String user = Config.getPropertyValue("user");
            String pwd = Config.getPropertyValue("password");
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("connecter");
        }
        catch(Exception e)
        {
            throw e;
        }
        return connection;
    }
    
}
