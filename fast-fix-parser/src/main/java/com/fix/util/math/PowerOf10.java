package com.fix.util.math;

public final class PowerOf10
{
    public static final long[] POWERS_OF_TEN = new long[]
            {1L, 10L, 100L, 1_000L, 10_000L, 100_000L, 1_000_000L, 10_000_000L,
                    100_000_000L, 1_000_000_000L, 10_000_000_000L, 100_000_000_000L,
                    1_000_000_000_000L, 10_000_000_000_000L, 100_000_000_000_000L,
                    1_000_000_000_000_000L, 10_000_000_000_000_000L, 100_000_000_000_000_000L,
                    1_000_000_000_000_000_000L, Long.MAX_VALUE};
    public static final int HIGHEST_POWER_OF_TEN = 18;

    public static long pow10(final int rhs)
    {
        if (rhs > HIGHEST_POWER_OF_TEN) {
            throw new ArithmeticException("Cannot raise 10 to the power of " + rhs);
        }
        return POWERS_OF_TEN[rhs];
    }
}
