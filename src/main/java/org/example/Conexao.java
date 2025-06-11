package org.example;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
        private static final String URL = "jdbc:postgresql://localhost:5432/BancoPOO";
        private static final String USUARIO = "postgres";
        private static final String SENHA = "postgres";

        public static Connection conectar() throws Exception{
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }
}
