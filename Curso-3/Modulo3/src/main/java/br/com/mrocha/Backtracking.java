package br.com.mrocha;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static List<List<Integer>> findSubsets(int[] S, int n) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(S, n, 0, new ArrayList<>(), result);
        return result;
    }
}
