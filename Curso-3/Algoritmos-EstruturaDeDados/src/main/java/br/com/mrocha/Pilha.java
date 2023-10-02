package br.com.mrocha;

import java.util.ArrayList;
import java.util.List;

public class Pilha {
    private ListaEncadeada lista;
    private Integer length;

    public Pilha() {
        this.lista = new ListaEncadeada();
        this.length = 0;
    }

    public void push(Elemento value) {
        this.lista.pushPilha(value);
        length++;
    }

    public void pop() {
        System.out.println("Valor removido: " + this.top());
        this.lista.removeValue(this.top());
    }

    public Integer top() {
        return lista.getFirst().getValue();
    }

    public Boolean isEmpty(){
        return this.size() == 0 ? true : false;
    }

    public Integer size() {
        return length;
    }
}
