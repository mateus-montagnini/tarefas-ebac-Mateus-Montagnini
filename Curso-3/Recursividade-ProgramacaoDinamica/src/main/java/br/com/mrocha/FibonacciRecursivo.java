package br.com.mrocha;

public class FibonacciRecursivo {

    public static int elementAt(int n) {
        if (n <= 1) {
            return n;
        }

        return elementAt(n -1) + elementAt(n - 2);
    }

    public static void main(String[] args) {
        int n = 2;

        System.out.println("Elemento " + n + ": " + elementAt(n));
    }
}
