package br.com.mrocha;

public class Elemento {
    private Integer value;
    private Elemento next;

    public Elemento(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Elemento getNext() {
        return next;
    }

    public void setNext(Elemento next) {
        this.next = next;
    }
}
