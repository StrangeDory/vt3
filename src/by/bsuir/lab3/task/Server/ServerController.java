package by.bsuir.lab3.task.Server;

import java.io.*;
import java.net.Socket;

public class ServerController extends Thread{

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ServerController(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String inputData;
        try {
            while (true) {
                inputData = in.readLine();
            }

        } catch (IOException ignored) {
        }

    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}

    }

    private void downService() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();

            }
        } catch (IOException ignored) {}
    }
}
