package client;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Admin {

    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket();

        InetAddress group = InetAddress.getByName("230.0.0.0");
        int port = 4446;

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Digite mensagens para enviar:");

        while (true) {
            String msg = teclado.readLine();

            byte[] buffer = msg.getBytes(StandardCharsets.UTF_8);

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);

            socket.send(packet);
        }
    }
}