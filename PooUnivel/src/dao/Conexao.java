
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/bdUnivel2?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "univel";

    public static Connection conectar() {
        Connection minhaConexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            minhaConexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado com sucesso ao MySQL");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do MySQL nao encontrado: " + e.getMessage());

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao MySQL: " + e.getMessage());
        }

        return minhaConexao;
    }
}
