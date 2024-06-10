import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private Boolean done;

    private ExecutorService pool;

    public Server() {
        connections = new ArrayList<>();
        done = false;
        System.out.println("Chat Server is running on port 1234");
    }

    @Override
    public void run() {

        try {
            server = new ServerSocket(9999);
            pool = Executors.newCachedThreadPool();

            while (!done) {
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }
        } catch (Exception e) {
            shutdown();
        }


    }

    public void broadcast(String Message) {
        for (ConnectionHandler ch : connections) {
            if (ch != null) {
                ch.sendMessage(Message);
            }
        }
    }

    public void shutdown() {

        try {
            done = true;
            pool.shutdown();
            if (!server.isClosed()) {
                server.close();
            }
            for (ConnectionHandler ch : connections) {
                ch.shutdown();
            }


        } catch (IOException e) {

        }
    }

    class ConnectionHandler implements Runnable {


        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        private String nickname;

        public ConnectionHandler(Socket client) {
            this.client = client;

        }

        @Override
        public void run() {
            try {


                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out.println("Please Enter your Name : ");

                nickname = in.readLine();
                System.out.println(nickname + " Connected !");
                broadcast(nickname + " Joined the chat !");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/quit ")) {
                        broadcast(nickname + "left the chat");
                        shutdown();
                    } else {
                        broadcast(nickname + ": " + message);
                    }
                }


            } catch (IOException e) {
                shutdown();
            }

        }

        public void sendMessage(String Message) {
            out.println(Message);
        }

        public void shutdown() {
            try {

                in.close();
                out.close();
                if (!client.isClosed())
                    client.close();
            } catch (IOException e) {

            }


        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}