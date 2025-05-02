package com.fix.util.bytes;

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

    public static char[] getChars(byte[] array, char[] oldTargetToCopy, int startInclusive, int endExclusive) {
        int length = endExclusive - startInclusive;
        char[] targetToCopy = oldTargetToCopy.length < length ? new char[length] : oldTargetToCopy;

        for (int i = 0; i < length; i++) {
            targetToCopy[i] = (char) array[startInclusive + i];
        }

        return targetToCopy;
    }

    public static String getString(byte[] array, int startInclusive, int endExclusive) {
        int length = endExclusive - startInclusive;

        return new String(array, startInclusive, length);
    }
}
