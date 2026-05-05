package client;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class ClienteMulticast {

    public static void main(String[] args) throws Exception {

        MulticastSocket socket = new MulticastSocket(4446);
        InetAddress group = InetAddress.getByName("230.0.0.0");

        socket.joinGroup(group);

        System.out.println("Aguardando mensagens do admin...");

        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String msg = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
            System.out.println("Mensagem recebida: " + msg);
        }
    }
}