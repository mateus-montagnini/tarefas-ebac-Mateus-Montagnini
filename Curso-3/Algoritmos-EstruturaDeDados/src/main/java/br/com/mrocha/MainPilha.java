package br.com.mrocha;

public class MainPilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        System.out.println("Pilha sem elemento? " + pilha.isEmpty());
        System.out.println("Tamanho da Pilha sem elementos: " + pilha.size());
        Elemento e1 = new Elemento(10);
        Elemento e2 = new Elemento(20);
        Elemento e3 = new Elemento(30);
        Elemento e4 = new Elemento(40);

        pilha.push(e1);
        pilha.push(e2);
        pilha.push(e3);
        pilha.push(e4);

        System.out.println("Pilha com elementos? " + pilha.isEmpty());
        System.out.println("Tamanho da Pilha com elementos: " + pilha.size());


        System.out.println("Topo: " + pilha.top());

        pilha.pop();

        System.out.println("Topo: " + pilha.top());

    }
}
