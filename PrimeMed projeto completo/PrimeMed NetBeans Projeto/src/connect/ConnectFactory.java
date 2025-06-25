package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/conexaomysql";
    private static final String USER = "root";  // ou o usuário que você usa
    private static final String PASSWORD = "admin";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
            return null;
        }
    }
}
