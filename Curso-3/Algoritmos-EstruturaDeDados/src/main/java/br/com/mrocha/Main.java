package br.com.mrocha;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.push(20);
        lista.push(30);
        lista.push(40);
        lista.push(50);
        System.out.println(lista.elementAt(0).getValue());
        System.out.println(lista.elementAt(1).getValue());
        System.out.println(lista.elementAt(2).getValue());
        System.out.println(lista.elementAt(3).getValue());
    }
}