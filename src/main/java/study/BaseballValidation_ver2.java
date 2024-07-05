package study;

import java.util.HashSet;
import java.util.Set;

public class BaseballValidation_ver2 {

    // ball
    public static boolean isNumberFrom1To9(int input) {
        final int MIN_NO = 0;
        final int MAX_NO = 10;
        return compareMinMax(input, MIN_NO, MAX_NO);
    }

    // balls
    public static boolean isThreeDigits(int input) {
        final int MIN_NO = 99;
        final int MAX_NO = 1000;
        return compareMinMax(input, MIN_NO, MAX_NO);
    }

    // ball
    private static boolean compareMinMax(int input, int MIN_NO, int MAX_NO) {
        return input > MIN_NO && input < MAX_NO;
    }

    // balls
    public static boolean isDuplicateNumber(int input) {
        String str = String.valueOf(input);
        Set<Character> digitsSet = new HashSet<>();
        for (char digit : str.toCharArray()) {
            if (digitsSet.contains(digit)) {
                return true;
            }
            digitsSet.add(digit);
        }
        return false;
    }
}
