package model;

public class Pedido {
    public int idPedido;
    public int idSuplemento;
    public int quantidade;

    public Pedido(int idPedido, int idSuplemento, int quantidade) {
        this.idPedido = idPedido;
        this.idSuplemento = idSuplemento;
        this.quantidade = quantidade;
    }
} 