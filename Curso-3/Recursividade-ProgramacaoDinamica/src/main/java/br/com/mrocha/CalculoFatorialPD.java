package br.com.mrocha;

public class CalculoFatorialPD {

    private static final int MAX_ELEMENTS = 100;
    private static long[] list = new long[MAX_ELEMENTS];

    public static long elementAtPD(int n) {
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            list[i] = -1;
        }

        return elementAt(n);
    }

    public static long elementAt(int n) {
        if (list[n] == -1) {
            if (n <= 1) {
                list[n] = n;
            } else {
                list[n] = n * elementAt(n - 1);
            }
        }
        return list[n];
    }

    public static void main(String[] args) {
        int n = 50;

        System.out.println("Elemento " + n + ": " + elementAtPD(n));
    }
}
