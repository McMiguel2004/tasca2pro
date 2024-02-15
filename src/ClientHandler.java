import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())
        ) {
            // Llegir l'objecte Llista del client
            Llista llista = (Llista) in.readObject();

            // Processar la llista (eliminar repetits i ordenar)
            llista.eliminarRepetits();
            llista.ordenarNumeros();

            // Enviar la llista processada al client
            out.writeObject(llista);
            out.flush();

            // Tancar la connexió amb el client
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
