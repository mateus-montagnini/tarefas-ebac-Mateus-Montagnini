package br.com.mrocha;

import java.util.ArrayList;
import java.util.List;

public class Greed {
    public static List<Integer> Troco(int quantidade, int[] moedas) {
        List<Integer> res = new ArrayList<>();
        int i = 0;

        while (quantidade > 0 && i < moedas.length) {
            if (moedas[i] <= quantidade) {
                res.add(moedas[i]);
                quantidade -= moedas[i];
            } else {
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int quantidade = 18;
        int[] moedas = {5, 2, 1};

        List<Integer> resultadoTroco = Troco(quantidade, moedas);
        System.out.println("Troco para " + quantidade + ": " + resultadoTroco);
    }
}
