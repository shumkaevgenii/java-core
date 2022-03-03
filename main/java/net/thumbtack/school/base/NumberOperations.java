package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberOperations {

    public static Integer find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) if (array[i] == value) return i;
        return null;
    }

    public static Integer find(double[] array, double value, double eps) {
        int count = 0;
        for (double i : array) {
            if (Math.abs(value) >= Math.abs(i) - Math.abs(eps) && Math.abs(value) <= Math.abs(i) + Math.abs(eps)) {
                return count;
            }
            count++;
        }
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        double q = weight / volume;
        if (q > min && q < max) return q;
        else return null;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        for (int i = 0; i < array.length; i++) if (array[i].equals(value)) return i;
        return null;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        BigDecimal q = weight.divide(volume);
        if (q.compareTo(min) > 0 && q.compareTo(max) < 0) return q;
        else return null;
    }

}
