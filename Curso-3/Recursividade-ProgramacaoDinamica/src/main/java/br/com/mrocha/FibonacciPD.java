package br.com.mrocha;

public class FibonacciPD {
    private static final int MAX_ELEMENT = 100;
    private static final long[] elementFibonacci = new long[MAX_ELEMENT];

    public static long elementAtPD(int n) {
        for (int i = 0; i < MAX_ELEMENT; i++) {
            elementFibonacci[i] = -1;
        }
        return elementAt(n);
    }

    public static long elementAt(int n) {
        if (elementFibonacci[n] == -1) {
            if (n <= 1) {
               elementFibonacci[n] = n;
            } else {
                elementFibonacci[n] = elementAt(n - 1) + elementAt(n - 2);
            }
        }

        return elementFibonacci[n];
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Elemento " + n + ": " + elementAtPD(n));
    }
}
