package br.com.mrocha;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        Elemento e1 = new Elemento(10);
        Elemento e2 = new Elemento(20);
        Elemento e3 = new Elemento(30);
        Elemento e4 = new Elemento(40);
        lista.push(e1);
        lista.push(e2);
        lista.push(e3);
        lista.push(e4);

        System.out.println(lista.size());
//        System.out.println(lista.elementAt(0).getValue());
//        System.out.println(lista.elementAt(1).getValue());
//        System.out.println(lista.elementAt(2).getValue());
//        System.out.println(lista.elementAt(3).getValue());

//        lista.remove(1);
//
//        System.out.println(lista.elementAt(0).getValue());
//        System.out.println(lista.elementAt(1).getValue());
//        System.out.println(lista.elementAt(2).getValue());
//        System.out.println(lista.elementAt(3).getValue());
//
//        System.out.println(lista.size());

//        System.out.println("Removeu: " + lista.pop().getValue());
//
//        System.out.println(lista.elementAt(0).getValue());
//        System.out.println(lista.elementAt(1).getValue());
//        System.out.println(lista.elementAt(2).getValue());
//        System.out.println(lista.elementAt(3).getValue());


        lista.printList();
        Elemento elemento = new Elemento(25);
        lista.insert(2, elemento);
        lista.printList();
    }
}
