package com.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
       private ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
       private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadLocalConn(){
        try {
            Connection conn = null;
            conn = t1.get();
            if (conn ==null){
                 conn = dataSource.getConnection();
                   t1.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("异常");
        }

    }

    public void removeConnection(){
        t1.remove();
    }
}
