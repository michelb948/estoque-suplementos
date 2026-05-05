package server;

import java.io.*;
import java.net.*;
import model.Suplemento;
import service.EstoqueService;

public class Servidor {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(1234);
        System.out.println("Servidor rodando na porta 1234...");

        EstoqueService estoque = new EstoqueService();


        estoque.adicionar(new Suplemento(1, "Whey Protein", "Growth", 120.0, 10));
        estoque.adicionar(new Suplemento(2, "Creatina", "Max Titanium", 80.0, 5));

        while (true) {
            Socket socket = server.accept();

            new Thread(() -> {
                try {
                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream();

                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    PrintWriter pw = new PrintWriter(out, true);

                    String msg = br.readLine();

                    if (msg.contains("\"acao\":\"listar\"")) {

                        for (Suplemento s : estoque.listar()) {
                            pw.println(s);
                        }

                    } else if (msg.contains("\"acao\":\"comprar\"")) {

                        
                        int id = Integer.parseInt(msg.split("\"id\":")[1].split(",")[0]);
                        int qtd = Integer.parseInt(msg.split("\"qtd\":")[1].split("}")[0]);

                        boolean sucesso = false;

                        for (Suplemento s : estoque.listar()) {
                            if (s.id == id && s.quantidade >= qtd) {
                                s.quantidade -= qtd;
                                sucesso = true;
                            }
                        }

                        if (sucesso) {
                            pw.println("{\"status\":\"ok\"}");
                        } else {
                            pw.println("{\"status\":\"erro\"}");
                        }
                    }

                    socket.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}