package br.com.mrocha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    public static List<List<Integer>> findSubsets(int[] S, int n) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(S, n, 0, new ArrayList<>(), res);
        return res;
    }

    private static void generateSubsets(int[] S, int n, int inicio, List<Integer> currentSubset, List<List<Integer>> res) {
        if (n == 0) {
            res.add(new ArrayList<>(currentSubset));
            return;
        }

        for (int i = inicio; i < S.length; i++) {
            currentSubset.add(S[i]);
            generateSubsets(S, n - 1, i + 1, currentSubset, res);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        int n = 2;
        List<List<Integer>> subset = findSubsets(S, n);
        System.out.println("Conjunto: " + Arrays.toString(S) + "\nNumero de subconjuntos: " + n + "\nSubconjuntos: " + subset);
    }
}
