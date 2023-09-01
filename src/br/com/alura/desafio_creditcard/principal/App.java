package br.com.alura.desafio_creditcard.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.com.alura.desafio_creditcard.cartao.Produto;
import br.com.alura.desafio_creditcard.cartao.Cartao;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Produto> listaDeCompras = new ArrayList<>();
        double limiteDefinido = 0;

        System.out.println("Limite do cartão: ");
        limiteDefinido = input.nextDouble();

        Cartao meuCartao = new Cartao(limiteDefinido, limiteDefinido);

        boolean menuCompras = true;
        String nomeProduto;
        double precoProduto;
        int estadoMenu;

        while (menuCompras == true) {
            System.out.println("Digite o nome do produto: ");
            nomeProduto = input.nextLine();
            nomeProduto = input.nextLine();
            System.out.println("Digite o valor do produto: ");
            precoProduto = input.nextDouble();
            if (meuCartao.getLimiteUtilizado() >= precoProduto) {
                Produto produto = new Produto(nomeProduto, precoProduto);
                listaDeCompras.add(produto);
                meuCartao.comprar(precoProduto);
                System.out.println("""
                **************************************
                Compra realizada!

                Digite 0 para sair ou 1 para continuar 
                **************************************""");
                estadoMenu = input.nextInt();
                switch (estadoMenu) {
                    case 0:
                        menuCompras = false;
                        imprimeReceita(listaDeCompras,meuCartao);
                        break;
                    case 1:
                        menuCompras = true;
                        break;
                    default:
                        System.out.println("Opção invalida");
                        break;
                }
            } else if (meuCartao.getLimiteUtilizado() < precoProduto){
                System.out.println("Saldo insuficiente!");
                imprimeReceita(listaDeCompras,meuCartao);
                menuCompras = false;
            }

        }
        input.close();
    }

    private static void imprimeReceita(List<Produto> listaDeCompras, Cartao meuCartao){
        Collections.sort(listaDeCompras);
        System.out.println("""
        *********************************
        Compras Realizadas: """);
        for (Produto produto : listaDeCompras){
            System.out.println(produto.getNome()+ " - " + produto.getValor());
        }
        System.out.println("Saldo do cartão: " + meuCartao.getLimiteUtilizado());
        System.out.println("Limite Total: " + meuCartao.getLimite());
    }
    
}
