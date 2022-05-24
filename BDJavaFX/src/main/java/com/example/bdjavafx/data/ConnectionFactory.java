package com.example.bdjavafx.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable{
    private static PreparedStatement stmt = null;
    private static Connection conn  = null;

    public  static Connection criaConexao() {
        try {
            if(conn == null)
                conn = DriverManager.getConnection("jdbc:sqlite:empresa.db");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static PreparedStatement criaStatement(String sql){
        try {stmt = criaConexao().prepareStatement(sql);}
        catch (SQLException e)
        { e.printStackTrace();}
        return stmt;
    }

    @Override
    public void close() throws Exception {
        if(conn != null)
            conn.close();
        if(stmt != null)
            stmt.close();
    }
}
