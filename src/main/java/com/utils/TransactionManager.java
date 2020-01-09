package com.utils;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }


    public void beginTransaction(){

        try {
            connectionUtils.getThreadLocalConn().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void commit(){
        try {
            connectionUtils.getThreadLocalConn().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } public void rollback(){
        try {
            connectionUtils.getThreadLocalConn().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void release(){
        try {
            connectionUtils.getThreadLocalConn().close();  //还回连接池中
            connectionUtils.removeConnection();   //解绑线程与连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
