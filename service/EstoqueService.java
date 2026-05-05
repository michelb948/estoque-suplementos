package service;

import model.Suplemento;
import java.util.ArrayList;
import java.util.List;

public class EstoqueService {

    private List<Suplemento> lista = new ArrayList<>();

    public void adicionar(Suplemento s) {
        lista.add(s);
    }

    public List<Suplemento> listar() {
        return lista;
    }

    public Suplemento buscarPorId(int id) {
        for (Suplemento s : lista) {
            if (s.id == id) return s;
        }
        return null;
    }
 
    public void atualizarQuantidade(int id, int qtd) {
        Suplemento s = buscarPorId(id);
        if (s != null) {
            s.quantidade = qtd;
        }
    }
}