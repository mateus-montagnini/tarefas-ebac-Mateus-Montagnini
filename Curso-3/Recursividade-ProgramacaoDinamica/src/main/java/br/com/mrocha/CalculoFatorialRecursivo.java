package br.com.mrocha;

public class CalculoFatorialRecursivo {

    public static long calcFatorial(int n) {
        if(n <= 1) {
            return 1;
        }
       return n * calcFatorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 50;
        System.out.println("Elemento " + n + ": " + calcFatorial(n));
    }
}
