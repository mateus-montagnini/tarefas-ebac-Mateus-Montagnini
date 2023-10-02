package br.com.mrocha;

import java.util.ArrayList;
import java.util.List;

public class Pilha {
    private ListaEncadeada lista;
    private Integer length;

    public Pilha() {
        this.lista = new ListaEncadeada();
    }

    public void push() {

    }

    public Elemento pop() {
        return null;
    }

    public Integer top() {
        return null;
    }

    public Boolean isEmpty(){
        return this.size() == 0 ? true : false;
    }

    public Integer size() {
        return length;
    }
}
