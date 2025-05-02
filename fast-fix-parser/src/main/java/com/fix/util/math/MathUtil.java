package com.fix.util.math;

public final class MathUtil {

    static final long[] POWERS_OF_TEN = new long[]{1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L, Long.MAX_VALUE};

    public static double toDouble(long value, int scale) {
        int remainingPowersOfTen = scale;

        double divisor;
        for (divisor = 1.0; remainingPowersOfTen >= 18; remainingPowersOfTen -= 18) {
            divisor *= (double) POWERS_OF_TEN[18];
        }

        divisor *= (double) POWERS_OF_TEN[remainingPowersOfTen];
        return (double) value / divisor;
    }

    public static double truncate(double value, int numberOfDecimalPlaces) {
        double multiplier = Math.pow(10, numberOfDecimalPlaces);
        return Math.floor(value * multiplier) / multiplier;
    }
}
