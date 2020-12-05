package com.mycompany.app;

import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class Tmp {
    public static void main(String[] args) throws InterruptedException {
        Collection<String> mensagens = new Vector<>();

        Thread t1 = new Thread(new ProduzMensagem(0, 10000, mensagens, 1));
        Thread t2 = new Thread(new ProduzMensagem(10000, 20000, mensagens, 2));
        Thread t3 = new Thread(new ProduzMensagem(20000, 30000, mensagens, 3));


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


        System.out.println("Threads produtoras de mensagens finalizadas!");
        if (mensagens.contains(null)) {
            throw new IllegalStateException("Mensagem com null");
        }
        for (int i = 0; i < 15000; i++) {
            if (!mensagens.contains("Mensagem " + i)) {
                throw new IllegalStateException("Não encontrei a mensagem " + i);
            }
        }
        System.out.println("Fim da execução");
    }
}


class ProduzMensagem implements Runnable {
    private int inicio;
    private int fim;
    private Collection<String> mensagens;
    private int id;

    public ProduzMensagem(int inicio, int fim, Collection<String> mensagens, int id) {
        this.inicio = inicio;
        this.fim = fim;
        this.mensagens = mensagens;
        this.id = id;
    }

    public void run() {

        synchronized (mensagens) {
            System.out.println("Inicio Threads " + id);
            for (int i = inicio; i < fim; i++) {
                String tmpMsg = "Mensagem " + i;
                mensagens.add(tmpMsg);
                System.out.println(tmpMsg);
            }
        }

        System.out.println("Fim Threads " + id);

    }

}