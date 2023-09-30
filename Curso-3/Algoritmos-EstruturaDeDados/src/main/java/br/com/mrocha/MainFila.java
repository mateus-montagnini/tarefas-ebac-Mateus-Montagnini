package br.com.mrocha;

public class MainFila {
    public static void main(String[] args) {
        Elemento e1 = new Elemento(10);
        Elemento e2 = new Elemento(20);
        Elemento e3 = new Elemento(30);
        Elemento e4 = new Elemento(40);
        Fila fila = new Fila();
        System.out.println("Sem nenhum elemento adicionado: " + fila.isEmpty());

        fila.enqueue(e1);
        fila.enqueue(e2);
        fila.enqueue(e3);
        fila.enqueue(e4);

        System.out.println("Primeiro elemento: " + fila.front());

        fila.dequeue();
        System.out.println("Primeiro elemento: " + fila.front());

//        System.out.println("Primeiro elemento: " + fila.front());
//        System.out.println("Ultimo elemento: " + fila.rear());
//        System.out.println("Com elementos adicionados: " + fila.isEmpty());
//        System.out.println("Tamanho da fila: " + fila.size());
//
//        fila.dequeue();
//        System.out.println("Novo primeiro elemento: " + fila.front());
//        System.out.println("Ultimo elemento: " + fila.rear());
//        System.out.println("Tamanho da fila: " + fila.size());
    }
}
