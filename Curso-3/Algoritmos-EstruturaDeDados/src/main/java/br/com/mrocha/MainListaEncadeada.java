package br.com.mrocha;

public class MainListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        Elemento e1 = new Elemento(10);
        Elemento e2 = new Elemento(20);
        Elemento e3 = new Elemento(30);
        Elemento e4 = new Elemento(40);
        Elemento e5 = new Elemento(50);
        Elemento e6 = new Elemento(60);
        System.out.println("Tamanho da lista sem elementos: " + lista.size());


        lista.push(e1);
        lista.push(e2);
        lista.push(e3);
        lista.push(e4);
        lista.push(e5);
        lista.push(e6);
        System.out.println("Tamanho da lista com elementos: " + lista.size());


        System.out.println("Indice 0: " + lista.elementAt(0).getValue());
        System.out.println("Indice 1: " + lista.elementAt(1).getValue());
        System.out.println("Indice 2: " + lista.elementAt(2).getValue());
        System.out.println("Indice 3: " + lista.elementAt(3).getValue());
        System.out.println("Indice 4: " + lista.elementAt(4).getValue());
        System.out.println("Indice 5: " + lista.elementAt(5).getValue());


        System.out.println("Removendo o elemento no indice 1");
        lista.remove(1);
        System.out.println("Lista atualizada:");
        lista.printList();


        System.out.println("\nNovo elemento no indice 1: " + lista.elementAt(1).getValue());

        System.out.println("Removendo ultimo elemento da lista");
        lista.pop();
        System.out.println("Lista atualizada:");
        lista.printList();

        Elemento elemento = new Elemento(25);
        System.out.println("\nAdicionando um novo elemento na lista");
        lista.insert(2, elemento);
        System.out.println("\nLista final:");
        lista.printList();

    }
}
