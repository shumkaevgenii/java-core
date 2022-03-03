package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public int sum(int[] array) {
        int Sum = 0;
        for (int i : array) Sum += i;
        return Sum;
    }

    public int mul(int[] array) {
        if (array.length == 0) return 0;
        int mul = 1;
        for (int i : array) mul *= i;
        return mul;
    }

    public int min(int[] array) {
        if (array.length == 0) return Integer.MAX_VALUE;
        int min = array[0];
        for (int i : array) if (min > i) min = i;
        return min;
    }

    public int max(int[] array) {
        if (array.length == 0) return Integer.MIN_VALUE;
        int max = array[0];
        for (int i : array) if (max < i) max = i;
        return max;
    }

    public double average(int[] array) {
        if (sum(array) == 0) return 0;
        int total = 0;
        int sum = sum(array);
        for (int i : array) if (i != 0) total++;
        return (double) sum / total;
    }

    public boolean isSortedDescendant(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1])
                return false;
        }
        return true;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        for (int i : array) if (i == value) return true;
        return false;
    }

    public void reverse(int[] array) {
        int end = array.length - 1;
        int begin = 0;
        while (begin < array.length / 2) {
            int cur = array[begin];
            array[begin] = array[end];
            array[end] = cur;
            begin++;
            end--;
        }
    }

    public boolean isPalindrome(int[] array) {
        int counter = 0;
        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            if (array[i] == array[j]) counter++;
        }
        return counter == array.length;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public int max(int[][] matrix) {
        if (matrix.length * matrix[0].length == 0) return Integer.MIN_VALUE;
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) if (max < matrix[i][j]) max = matrix[i][j];
        }
        return max;
    }


    public int diagonalMax(int[][] matrix) {
        if (matrix.length * matrix.length == 0) return Integer.MIN_VALUE;
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) if (max < matrix[i][i]) max = matrix[i][i];
        return max;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!isSortedDescendant(matrix[i])) return false;
        }
        return true;
    }

}
