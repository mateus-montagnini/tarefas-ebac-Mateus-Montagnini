package br.com.mrocha;

public class ListaEncadeada {
    private Elemento first;
    private Elemento last;
    private Integer length;

    public Elemento getFirst() {
        return first;
    }

    public ListaEncadeada() {
        this.length = 0;
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
        length++;
    }

    public Elemento pop() {
        Elemento previous = null;
        Elemento current = first;
        for(int i = 0; i < this.size(); i++) {
            if(current.getNext() != null) {
                previous = current;
                current = current.getNext();
            }
        }
        Elemento removedNode = current;
        previous.setNext(current.getNext());
        current = null;
        length--;
        return removedNode;
    }

    public void insert(int index, Elemento elemento) {

    }

    public void remove(int index) {
        Elemento previous = null;
        Elemento current = first;
        for(int i = 0; i < index; i++) {
            if(current.getNext() != null) {
                previous = current;
                current = current.getNext();
            }
        }
        previous.setNext(current.getNext());
        current = null;
        length--;
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
        return length;
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
