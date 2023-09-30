package br.com.mrocha;

import java.util.ArrayList;
import java.util.List;

public class Fila {

    private ListaEncadeada lista;
    private Integer length;

//    public Fila() {
//        this.lista = new ArrayList<>();
//    }

    public void enqueue(Elemento value) {
        this.lista.push(value);
    }



    public Integer size() {
        return length;
    }

    public Boolean isEmpty() {
        return true;
    }

}
