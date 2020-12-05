package com.mycompany.app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket server = new Socket("127.0.0.1", 12345);
            PrintStream saida = new PrintStream(server.getOutputStream());
            System.out.println("Cliente conectou");

            /*
            Scanner serverMsg = new Scanner(server.getInputStream());
            System.out.println(serverMsg.nextLine());
             */
            ObjectInputStream objInput = new ObjectInputStream(server.getInputStream());
            Message serverMsg = (Message) objInput.readObject();
            System.out.println(serverMsg.getMessage());

            Scanner teclado = new Scanner(System.in);
            while (teclado.hasNextLine()) {
                var out = new ObjectOutputStream(server.getOutputStream());
                Message msg = new Message(MessageTypes.MESSAGE, teclado.nextLine());
                out.writeObject(msg);
//                saida.println(teclado.nextLine());
            }
            saida.close();
            teclado.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
