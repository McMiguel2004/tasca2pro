import java.io.IOException;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // Adreça IP del servidor
        int port = 12345; // Podeu canviar el port segons les vostres necessitats

        try {
            Socket socket = new Socket(serverIP, port);
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
