package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private Map<Set<Integer>,int[]> nonSimilarMatrix;


    public MatrixNonSimilarRows(int[][] matrix) {
        nonSimilarMatrix = new HashMap<>();

        for(int[] array : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int value : array) {
                set.add(value);
            }
            nonSimilarMatrix.put(set, array);
        }
    }

    public List<int[]> getNonSimilarRows() { return new LinkedList<>(nonSimilarMatrix.values()); }
}