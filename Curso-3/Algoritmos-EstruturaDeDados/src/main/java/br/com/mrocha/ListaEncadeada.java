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

    public void push(Elemento elemento) {
        if(first == null && last == null) {
            first = elemento;
            last = elemento;
        } else {
            last.setNext(elemento);
            last = elemento;
        }
        length++;
    }

    public void pushPilha(Elemento elemento) {
        if(first == null && last == null) {
            first = elemento;
            last = elemento;
        } else {
            elemento.setNext(first);
            first = elemento;
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
        Elemento previous = null;
        Elemento current = first;
        for (int i = 0; i < index; i++) {
            if(current.getNext() != null) {
                previous = current;
                current = current.getNext();
            }
        }
        Elemento newElemnt = elemento;
        newElemnt.setNext(current);
        previous.setNext(newElemnt);
        length++;
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

    public void removeValue(int value){
        Elemento previous = null;
        Elemento current = first;
        for(int i=0; i < this.size(); i++){
            if (current.getValue().equals(value)){
                if (length == 1){
                    first = null;
                    last = null;
                }else if (current == first){
                    first = current.getNext();
                    current.setNext(null);
                }else if (current == last){
                    last = previous;
                    previous.setNext(null);
                }else{
                    previous.setNext(current.getNext());
                    current = null;
                }
                length--;
                break;
            }
            previous = current;
            current = current.getNext();
        }
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
        for(int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).getValue());
        }
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

    public Elemento get(Integer index) {
        Elemento current = first;
        for (int i = 0; i < index; i++) {
            if (current.getNext() != null) {
                current = current.getNext();
            }
        }
        return current;
    }
}
