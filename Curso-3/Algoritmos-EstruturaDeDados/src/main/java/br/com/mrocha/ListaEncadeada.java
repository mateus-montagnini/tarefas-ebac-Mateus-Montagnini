package br.com.mrocha;

public class ListaEncadeada {
    private Elemento first;
    private Elemento last;
    public Elemento getFirst() {
        return first;
    }

    public ListaEncadeada() {

    }

    public void push(Integer value) {
        Elemento elemento = new Elemento(value);
        if(first == null && last == null) {
            first = elemento;
            last = elemento;
        } else {
            last.setNext(elemento);
            last = elemento;
        }
    }

    public Elemento pop() {
        return null;
    }

    public void insert(int index, Elemento elemento) {

    }

    public void remove(int index) {

    }

    public Elemento elementAt(int index) {
        Elemento current = first;
        for(int i = 0; i < index; i++) {
            if(current.getNext() != null) {
                current = current.getNext();
            }
        }
        return current;
    }

    public Integer size() {
        return null;
    }

    public void printList() {
        System.out.println(ListaEncadeada.class.toString());
    }

    public void setFirst(Elemento first) {
        this.first = first;
    }

    public Elemento getLast() {
        return last;
    }

    public void setLast(Elemento last) {
        this.last = last;
    }
}
