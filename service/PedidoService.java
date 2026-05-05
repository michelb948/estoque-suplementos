package service;

import model.Suplemento;

public class PedidoService {

    private EstoqueService estoque;

    public PedidoService(EstoqueService estoque) {
        this.estoque = estoque;
    }

    public boolean comprar(int id, int quantidade) {
        Suplemento s = estoque.buscarPorId(id);

        if (s != null && s.quantidade >= quantidade) {
            s.quantidade -= quantidade; 
            return true;
        }

        return false;
    }
}