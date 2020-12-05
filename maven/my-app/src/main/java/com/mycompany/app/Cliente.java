package com.mycompany.app;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("127.0.0.1", 12345);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            System.out.println("Cliente conectou");

            Scanner serverMsg = new Scanner(cliente.getInputStream());
    
            System.out.println(serverMsg.nextLine());

            Scanner teclado = new Scanner(System.in);
            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }
            saida.close();
            teclado.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
