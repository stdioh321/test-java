package com.mycompany.app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
            Socket tmpClient = this.serverSocket.accept();
            this.clientes.add(tmpClient);
            User currentUser = new User("Mario", new Date());
            clients.putIfAbsent(currentUser, tmpClient);

            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            executor.submit(() -> {
                try {
                    var out = new PrintWriter(tmpClient.getOutputStream(), true);
                    out.println("Welcome: " + currentUser.getId());
                    Scanner scanner = new Scanner(tmpClient.getInputStream());
                    while (scanner.hasNextLine()) {
                        String msg = currentUser.getId() + ": " + scanner.nextLine();
                        System.out.println(msg);
                        clients.forEach((user, socket) -> {
                            if (user.getId() == currentUser.getId()) {
                            } else {
                                try {
                                    var tmpOut = new PrintWriter(socket.getOutputStream(), true);
                                    tmpOut.println(msg);
                                } catch (Exception e) {

                                }

                            }
                        });

                    }
                    if (clients.containsKey(currentUser)) {
                        tmpClient.close();
                        clients.remove(currentUser);

                    }
                    scanner.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            /*
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

             */
        }
    }

}

