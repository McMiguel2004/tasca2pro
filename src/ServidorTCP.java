import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) {
        int port = 12345; // Podeu canviar el port segons les vostres necessitats

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor TCP esperant connexions...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connectat: " + clientSocket.getInetAddress());

                // Crear un nou fil per gestionar la comunicació amb aquest client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
