package br.com.mrocha;

import java.util.ArrayList;
import java.util.List;

public class CalculoFatorialRecursivo {

    public static long calcFatorial(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
       return n * calcFatorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(calcFatorial(20));
    }
}
