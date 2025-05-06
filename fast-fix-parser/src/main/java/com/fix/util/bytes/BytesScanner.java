package com.fix.util.bytes;

import com.fix.util.math.DecimalFloat;

public class BytesScanner {

    public static int scan(byte[] array, int startInclusive, int endExclusive, byte matcher) {
        for (int i = startInclusive; i < endExclusive; i++) {
            if (array[i] == matcher) {
                return i;
            }
        }
        return -1;
    }

    public static int getInt(byte[] array, int startInclusive, int endExclusive) {
        int result = 0;
        for (int i = startInclusive; i < endExclusive; i++) {
            result = result * 10 + (array[i] - '0');
        }
        return result;
    }

    public static char getChar(byte[] array, int startInclusive) {
        return (char) array[startInclusive];
    }

    public static char[] getChars(byte[] array, char[] oldTargetToCopy, int startInclusive, int endExclusive) {
        int length = endExclusive - startInclusive;
        char[] targetToCopy = oldTargetToCopy.length < length ? new char[length] : oldTargetToCopy;

        for (int i = 0; i < length; i++) {
            targetToCopy[i] = (char) array[startInclusive + i];
        }

        return targetToCopy;
    }

    public static void getDecimalFloat(byte[] array, DecimalFloat decimalFloat, int startInclusive, int endExclusive) {
        long value = 0L;
        int scale = 0;
        boolean shouldIncreaseScale = false;
        for (int i = startInclusive; i < endExclusive; i++) {
            if (array[i] == '.') {
                shouldIncreaseScale = true;
            } else {
                if (shouldIncreaseScale) {
                    scale++;
                }
                value = value * 10 + (array[i] - '0');
            }
        }
        decimalFloat.setValue(value);
        decimalFloat.setScale(scale);
    }
}
