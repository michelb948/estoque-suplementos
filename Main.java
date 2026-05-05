import stream.SuplementoOutputStream;
import java.io.*;
import model.Suplemento;
import service.EstoqueService;
import service.PedidoService;
import stream.SuplementoInputStream;

public class Main {
    public static void main(String[] args) throws Exception {

        EstoqueService estoque = new EstoqueService();
        PedidoService pedido = new PedidoService(estoque);

        estoque.adicionar(new Suplemento(1, "Whey Protein", "Growth", 120.0, 10));
        estoque.adicionar(new Suplemento(2, "Creatina", "Max Titanium", 80.0, 5));

        System.out.println("=== ESTOQUE ===");
        for (Suplemento s : estoque.listar()) {
            System.out.println(s);
        }

        System.out.println("\nComprando 2 Whey...");
        pedido.comprar(1, 2);

        System.out.println("\n=== ESTOQUE ATUALIZADO ===");
        for (Suplemento s : estoque.listar()) {
            System.out.println(s);
        }

        System.out.println("\n=== TESTE OUTPUTSTREAM (System.out) ===");

        Suplemento[] array = estoque.listar().toArray(new Suplemento[0]);

        new SuplementoOutputStream(array, array.length, System.out);

        System.out.println("\n=== Salvando em arquivo ===");

        FileOutputStream fos = new FileOutputStream("dados.bin");

        new SuplementoOutputStream(array, array.length, fos);

        fos.close();

        System.out.println("\n=== LENDO DO ARQUIVO ===");   

        FileInputStream fis = new FileInputStream("dados.bin");

        SuplementoInputStream sis = new SuplementoInputStream(fis);

        Suplemento[] lidos = sis.ler();

        for (Suplemento s : lidos) {
            System.out.println(s);
        }

        fis.close();
    }
}