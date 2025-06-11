package org.example;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ContaDAO dao = new ContaDAO();

        Conta nova = new Conta(101, "João", 500.0);
        dao.inserir(nova);

        Conta conta = dao.buscar(101);
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Saldo: R$ " + conta.getSaldo());

        dao.atualizarSaldo(101, conta.getSaldo() + 200); // depósito

        List<Conta> todas = dao.listarTodas();
        todas.forEach(c -> System.out.println(c.getNumero() + " - " + c.getTitular()));
    }
}

