package org.example;

public class Conta {
    private int numero;
    private String titular;
    private double  saldo;

    //construtor
    public Conta (int numero, String titular){
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;


    }

    public int getNumero() {
        return numero;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //metodo de entrada
    public void depositar(double valor){
        if(valor > 0){
            saldo += valor;
        }else{
            System.out.println("erro, valor insuficiente");
        }
    }
    public void sacar (double valor){
        if (valor> 0 && valor <= saldo){
            saldo -= valor;
        }else{
            System.out.println("erro, saldo insuficiente");
        }
    }
    public void exibirExtrato(){
        System.out.println("Conta: " + numero);
        System.out.println("titular: "+ titular);
        System.out.printf("Saldo Atual: R$ %.2f\n", saldo);
    }

    public Conta(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }
}
