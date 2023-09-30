package br.com.mrocha;

import java.util.ArrayList;
import java.util.List;

public class Fila {

    private ListaEncadeada lista;
    private Integer length = 0;

    public Fila() {
        this.lista = new ListaEncadeada();
    }

    public void enqueue(Elemento value) {
        this.lista.push(value);
        length++;
    }

    public void dequeue() {
        this.lista.pop();
        length--;
    }

    public Integer rear() {
        return this.lista.getLast().getValue();
    }

    public Integer front() {
        return this.lista.getFirst().getValue();
    }

    public Integer size() {
        return length;
    }

    public Boolean isEmpty() {
        return this.size() == 0 ? true : false;
    }

}
