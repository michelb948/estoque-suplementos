package stream;

import model.Suplemento;
import java.io.*;

public class SuplementoOutputStream extends OutputStream {

    private DataOutputStream dos;

    public SuplementoOutputStream(Suplemento[] suplementos, int n, OutputStream out) throws IOException { 
        this.dos = new DataOutputStream(out);

        
        dos.writeInt(n);

        
        for (int i = 0; i < n; i++) {
            dos.writeInt(suplementos[i].id);
            dos.writeUTF(suplementos[i].nome);
            dos.writeUTF(suplementos[i].marca);
            dos.writeDouble(suplementos[i].preco);
            dos.writeInt(suplementos[i].quantidade);
        }

        dos.flush();
    }

    @Override
    public void write(int b) throws IOException {
        dos.write(b);
    }
}