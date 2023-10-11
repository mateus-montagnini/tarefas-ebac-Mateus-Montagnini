package br.com.mrocha;

import java.util.ArrayList;
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
}
