package net.thumbtack.school.base;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int total = 0;
        for (String i : strings) total += i.length();
        return total;
    }

    public static String getFirstAndLastLetterString(String string) {
        return new String(new char[]{string.charAt(0), string.charAt(string.length() - 1)});
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        int ind1 = -1, ind2 = -2;
        for (int i = 0; i < string1.length(); i++)
            if (string1.charAt(i) == character) {
                ind1 = string1.charAt(i);
                break;
            }
        for (int i = 0; i < string2.length(); i++)
            if (string2.charAt(i) == character) {
                ind2 = string2.charAt(i);
                break;
            }
        return ind1 == ind2;
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        int ind1 = -1, ind2 = -2;
        for (int i = string1.length() - 1; i >= 0; i--)
            if (string1.charAt(i) == character) {
                ind1 = string1.charAt(i);
                break;
            }
        for (int i = string2.length() - 1; i >= 0; i--)
            if (string2.charAt(i) == character) {
                ind2 = string2.charAt(i);
                break;
            }
        return ind1 == ind2;
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        int ind1 = string1.indexOf(str), ind2 = string2.indexOf(str);
        return ind1 == ind2 && ind1 != -1;
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        int ind1 = string1.lastIndexOf(str), ind2 = string2.lastIndexOf(str);
        return ind1 == ind2 && ind1 != -1;
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return new String(string1 + string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int len = 0, Mlen = 0;
        if (string1.length() < string2.length()) Mlen = string1.length();
        else Mlen = string2.length();
        for (int i = 0; i < Mlen; i++)
            if (string1.charAt(i) == string2.charAt(i)) len++;
            else break;
        StringBuilder str = new StringBuilder(len);
        for (int i = 0; i < len; i++) str.insert(i, string1.charAt(i));
        if (len == 0) return "";
        else return str.toString();
    }

    public static String reverse(String string) {
        StringBuilder str = new StringBuilder(string);
        return str.reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        for (int i = 0, j = string.length() - 1; i < string.length(); i++, j--)
            if (string.charAt(i) != string.charAt(j)) return false;
        return true;
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return isPalindrome(string.toLowerCase());
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        int maxLength = 0;
        String result = null;
        for (String str : strings) {
            if (isPalindromeIgnoreCase(str) && str.length() > maxLength) {
                maxLength = str.length();
                result = str;
            }
        }
        return result;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        int count = 0;
        for (int i = index; i < index + length; i++) {
            if (string1.charAt(i) == string2.charAt(i)) count++;
            else break;
            if (string1.length() - 1 == i || string2.length() - 1 == i) break;
        }
        if (count == length) return true;
        else return false;
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replaceAll(replaceInStr1, replaceByInStr1).equals(string2.replaceAll(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        StringBuilder str = new StringBuilder(string.toLowerCase().replaceAll("\\s+", ""));
        return isPalindromeIgnoreCase(str.toString());
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        String d = "";
        StringBuilder str = new StringBuilder();
        for (int i : array) {
            str.append(d).append(i);
            d = ",";
        }
        return str.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        String d = "";
        StringBuilder str = new StringBuilder();
        for (double i : array) {
            str.append(d).append(String.format("%.2f", i));
            d = ",";
        }
        return str.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        String d = "";
        StringBuilder str = new StringBuilder();
        for (int i : array) {
            str.append(d).append(i);
            d = ",";
        }
        return str;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        String d = "";
        StringBuilder str = new StringBuilder();
        for (double i : array) {
            str.append(d);
            str.append(String.format("%.2f", i));
            d = ",";
        }
        return str;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder str = new StringBuilder(string);
        for (int i = 0; i < positions.length; i++) {
            str.deleteCharAt(positions[i] - i);
        }
        return str;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder str = new StringBuilder(string);
        for (int i = 0; i < positions.length; i++) str.insert(positions[i] + i, characters[i]);
        return str;
    }
}
