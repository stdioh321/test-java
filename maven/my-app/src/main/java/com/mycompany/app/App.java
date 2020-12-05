package com.mycompany.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try {
            Servidor servidor = new Servidor(12345);
            servidor.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
