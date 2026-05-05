package client;

import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String[] args) throws Exception {

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Listar suplementos");
            System.out.println("2 - Comprar suplemento");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = Integer.parseInt(teclado.readLine());

            if (opcao == 0) {
                System.out.println("Encerrando...");
                break;
            }

            Socket socket = new Socket("localhost", 1234);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String json = "";

            if (opcao == 1) {
                json = "{\"acao\":\"listar\"}";
            }

            else if (opcao == 2) {
                System.out.print("ID do produto: ");
                int id = Integer.parseInt(teclado.readLine());

                System.out.print("Quantidade: ");
                int qtd = Integer.parseInt(teclado.readLine());

                json = "{\"acao\":\"comprar\",\"id\":" + id + ",\"qtd\":" + qtd + "}";
            }

            pw.println(json);

            System.out.println("\n=== RESPOSTA ===");

            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

            socket.close();
        }
    }
}