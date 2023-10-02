package br.com.mrocha;

import java.util.ArrayList;
import java.util.List;

public class Pilha {
    private ListaEncadeada lista;
    private Integer length;

    public Pilha() {
        this.lista = new ListaEncadeada();
    }

    public void push(Elemento value) {
    }

    public Integer pop() {
        this.lista.removeValue(this.top());
        return this.top();
    }

    public Integer top() {
        return lista.getLast().getValue();
    }

    public Boolean isEmpty(){
        return this.size() == 0 ? true : false;
    }

    public Integer size() {
        return length;
    }
}
