package stream;

import model.Suplemento;
import java.io.*;

public class SuplementoInputStream extends InputStream {

    private DataInputStream dis;

    public SuplementoInputStream(InputStream in) {
        this.dis = new DataInputStream(in);
    }

    public Suplemento[] ler() throws IOException {

        int n = dis.readInt();
        Suplemento[] lista = new Suplemento[n];

        for (int i = 0; i < n; i++) {
            int id = dis.readInt();
            String nome = dis.readUTF();
            String marca = dis.readUTF();
            double preco = dis.readDouble();
            int quantidade = dis.readInt();

            lista[i] = new Suplemento(id, nome, marca, preco, quantidade);
        }

        return lista;
    }

    @Override
    public int read() throws IOException {
        return dis.read();
    }
}