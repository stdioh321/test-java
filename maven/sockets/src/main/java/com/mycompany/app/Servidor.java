package com.mycompany.app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


@Getter
@Setter
public class Servidor {
    public int port = 12345;
    public ServerSocket serverSocket;
    public Socket cliente;
    public List<Socket> clientes = new ArrayList<>();
    public Map<User, Socket> clients = new HashMap<>();

    public Servidor(int port) throws IOException {
        this.port = port;
        this.init();
    }

    public Servidor init() throws IOException {
        this.serverSocket = new ServerSocket(this.port);
        return this;
    }

    public void start() throws IOException {
        System.out.println("Servidor iniciou");

        while (true) {
            Socket currentClient = this.serverSocket.accept();
            var clientOut = new PrintWriter(currentClient.getOutputStream(), true);
            /*
            var os = currentClient.getOutputStream();
            var osw = new OutputStreamWriter(new BufferedOutputStream(os));
            osw.write("Welcome to the server: \n\n");
            osw.flush();


             */
            ObjectOutputStream objOut = new ObjectOutputStream(currentClient.getOutputStream());
            Message msg = new Message(MessageTypes.MESSAGE, "Welcome to the server: ");
            objOut.writeObject(msg);
            
            // objOut.flush();
            //clientOut.println("Welcome to the server: ");
    
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            executor.submit(() -> {
                try {
                    Scanner scanner = new Scanner(currentClient.getInputStream());
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }
    }

}

