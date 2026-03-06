package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    protected Connection conexao;

    public boolean conectar() {
        String driverName = "org.postgresql.Driver";
        String serverName = "localhost";
        String mydatabase = "ti2cc";
        int porta = 5432;
        String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
        String username = "postgres";
        String password = "25felipe";
        boolean status = false;

        try {
            Class.forName(driverName);
            conexao = DriverManager.getConnection(url, username, password);
            status = (conexao != null);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return status;
    }

    public boolean close() {
        try {
            conexao.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}