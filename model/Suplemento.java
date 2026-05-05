package model;

public class Suplemento {
    public int id;
    public String nome;
    public String marca;
    public double preco;
    public int quantidade;

    public Suplemento(int id, String nome, String marca, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " (" + marca + ") | R$" + preco + " | Qtd: " + quantidade;
    }
}  