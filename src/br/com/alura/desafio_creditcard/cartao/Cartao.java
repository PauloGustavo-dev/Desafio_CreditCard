package br.com.alura.desafio_creditcard.cartao;

public class Cartao {
    private double limite;
    private double limiteUtilizado;

    public Cartao(double limite, double limiteUtilizado) {
        this.limite = limite;
        this.limiteUtilizado = limiteUtilizado;
    }

    public double getLimite() {
        return limite;
    }
    public double getLimiteUtilizado() {
        return limiteUtilizado;
    }

    public void comprar(double precoProduto){
        this.limiteUtilizado -= precoProduto;
    }

    
}
