package br.com.alura.desafio_creditcard.cartao;

public class Produto  implements Comparable<Produto>{
    private String nome;
    private double valor;
    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public double getValor() {
        return valor;
    }
    @Override
    public int compareTo(Produto outroProduto) {
        return Double.valueOf(this.getValor()).compareTo(Double.valueOf(outroProduto.getValor()));
    }
}
