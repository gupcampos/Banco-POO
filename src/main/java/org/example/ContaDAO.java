package org.example;
import java.sql.*;
import java.util.*;

public class ContaDAO {

    public void inserir (Conta conta) throws Exception {
        String sql = "INSERT INTO conta (numero, titular, saldo) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, conta.getNumero());
            stmt.setString(2, conta.getTitular());
            stmt.setDouble(3, conta.getSaldo());
            stmt.executeUpdate();
        }
    }
        public Conta buscar (int numero) throws Exception{
            String sql = "SELECT * FROM conta WHERE numero = ?";
           try (Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){
               stmt.setInt(1, numero);
               ResultSet rs = stmt.executeQuery();
               if(rs.next()){
                   return new Conta(rs.getInt("numero"), rs.getString("titular"), rs.getDouble("saldo"));
               }
           }
           return null;
           }

        public void atualizarSaldo (int numero, double novoSaldo) throws Exception{
            String sql =  "UPDATE conta SET saldo = ? where numero = ?";
            try (Connection conn = Conexao.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setDouble(1, novoSaldo);
                stmt.setInt(2, numero);
                stmt.executeUpdate();
            }
            }
        public List<Conta> listarTodas() throws Exception{
            List<Conta> contas = new ArrayList<>();
            String sql = "SELECT * FROM conta";
            try(Connection conn= Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    contas.add(new Conta(rs.getInt("numero"), rs.getString("titular"), rs.getDouble("saldo")));

                }
            }
        return contas;
        }
        }

