package com.fix.util.math;


import static com.fix.util.math.PowerOf10.HIGHEST_POWER_OF_TEN;
import static com.fix.util.math.PowerOf10.POWERS_OF_TEN;

/**
 * Fix float data type. Floats are used for a variety of things, including price.
 * <p>
 * Must support 15 significant digits, decimal places variable.
 * <p>
 * Decimal float represents the significant digits using a value field,
 * and the location of the point using the scale field.
 * <p>
 * See http://fixwiki.org/fixwiki/FloatDataType for details. Examples:
 * <p>
 * 55.36
 * 55.3600
 * 0055.36
 * 0055.3600
 * .995
 * 0.9950
 * 25
 * -55.36
 * -0055.3600
 * -55.3600
 * -.995
 * -0.9950
 * -25
 */
public class DecimalFloat extends ReadOnlyDecimalFloat
{
    private static final int SCALE_NAN_VALUE = -128;
    private static final long VALUE_NAN_VALUE = Long.MIN_VALUE;

    private static final long VALUE_MAX_VAL = 999_999_999_999_999_999L;
    private static final double VALUE_MAX_VAL_AS_DOUBLE = VALUE_MAX_VAL;
    private static final long VALUE_MIN_VAL = -VALUE_MAX_VAL;
    private static final double VALUE_MIN_VAL_AS_DOUBLE = VALUE_MIN_VAL;
    private static final int SCALE_MAX_VAL = 127;

    // FRACTION_LOWER_THRESHOLD and FRACTION_UPPER_THRESHOLD are used when converting
    // the fractional part of a double to ensure that discretisation errors are corrected.
    // E.g. The actual number 0.123 might be held in binary as something like 0.1230000000000000001
    //      and actual number 0.456 might be held in binary as 0.4559999999999999999999
    // The while-loop and if-statement below using the *_THRESHOLD constants will ensure the
    // correct number (0.123 and 0.456) is represented in the DecimalFloat.
    private static final double FRACTION_LOWER_THRESHOLD = 1e-7;
    private static final double FRACTION_UPPER_THRESHOLD = 1.0 - FRACTION_LOWER_THRESHOLD;

    public DecimalFloat()
    {
        this(0, 0);
    }

    public DecimalFloat(final long value)
    {
        this(value, 0);
    }

    public DecimalFloat(final long value, final int scale)
    {
        super(value, scale);
    }

    /**
     * Resets the encoder to the NAN value. This can checked using the {@link #isNaNValue()} method.
     */
    public void reset()
    {
        setValue(VALUE_NAN_VALUE);
        setScale(SCALE_NAN_VALUE);

        // Deliberately doesn't normalise, as that validates the arithmetic range.
    }

    public DecimalFloat set(final ReadOnlyDecimalFloat other)
    {
        setValue(other.getValue());
        setScale(other.getScale());
        return this;
    }

    /**
     * Sets the value of the DecimalFloat to the same as a long value.
     *
     * @param value the value to set
     * @return this
     */
    public DecimalFloat fromLong(final long value)
    {
        setAndNormalise(value, 0);
        return this;
    }

    public DecimalFloat set(final long value, final int scale)
    {
        setAndNormalise(value, scale);
        return this;
    }

    /*
     * Please use set(newValue, newScale) instead of value(newValue) and scale(newScale)
     */
    @Deprecated
    public DecimalFloat value(final long value)
    {
        setValue(value);
        return this;
    }

    /*
     * Please use set(newValue, newScale) instead of value(newValue) and scale(newScale)
     */
    @Deprecated
    public DecimalFloat scale(final int scale)
    {
        setScale(scale);
        return this;
    }

    public DecimalFloat negate()
    {
        long v = getValue();
        setValue(v * -1);
        return this;
    }

    public DecimalFloat copy()
    {
        return new DecimalFloat(getValue(), getScale());
    }

    /**
     * @return a copy that is guaranteed not to change value
     */
    public ReadOnlyDecimalFloat immutableCopy()
    {
        return isNaNValue() ? NAN : new ReadOnlyDecimalFloat(getValue(), getScale());
    }

    public boolean fromDouble(final double doubleValue)
    {
        if (Double.isNaN(doubleValue))
        {
            setValue(VALUE_NAN_VALUE);
            setScale(SCALE_NAN_VALUE);
            return true;
        }
        if (!Double.isFinite(doubleValue) ||
                isOutsideLimits(doubleValue, VALUE_MIN_VAL_AS_DOUBLE, VALUE_MAX_VAL_AS_DOUBLE))
        {
            return false;
        }
        if (doubleValue == 0.0)
        {
            setValue(0L);
            setScale(0);
            return true;
        }
        final boolean isNegative = doubleValue < 0.0;
        double remainingValue = Math.abs(doubleValue);
        long newValue = (long)remainingValue;
        // Have to repeat the limit verification, as the test above on the doubleValue is not exact.
        // It cuts the worst offenders and allows us to cast to a long,
        // but it lets through bad values within about 64 of the limits.
        if (isOutsideLimits(newValue, VALUE_MIN_VAL, VALUE_MAX_VAL))
        {
            return false;
        }
        int newScale = 0;
        remainingValue -= newValue;
        if (remainingValue == 0.0)
        {
            setAndNormalise(signedValue(isNegative, newValue), newScale);
            return true;
        }
        while (canValueAcceptMoreDigits(newValue, newScale) &&
                (newValue == 0L ||
                        !isOutsideLimits(remainingValue, FRACTION_LOWER_THRESHOLD, FRACTION_UPPER_THRESHOLD)))
        {
            remainingValue *= 10.0;
            final double digit = Math.floor(remainingValue);
            remainingValue -= digit;
            newValue = newValue * 10L + (long)digit;
            ++newScale;
        }
        if (FRACTION_UPPER_THRESHOLD < remainingValue)
        {
            newValue++;
        }
        setAndNormalise(signedValue(isNegative, newValue), newScale);
        return true;
    }

    public DecimalFloat fromString(final CharSequence string)
    {
        return fromString(string, 0, string.length());
    }

    public DecimalFloat fromString(final CharSequence string, final int start, final int length)
    {
        return DecimalFloatParser.extract(this, CharSequenceCharReader.INSTANCE, string, start, length);
    }

    public static DecimalFloat newNaNValue()
    {
        return ReadOnlyDecimalFloat.NAN.mutableCopy();
    }

    private static boolean canValueAcceptMoreDigits(final long value, final int scale)
    {
        return value <= POWERS_OF_TEN[HIGHEST_POWER_OF_TEN - 1] && scale < SCALE_MAX_VAL;
    }

    private static boolean isOutsideLimits(final long value, final long lowerBound, final long upperBound)
    {
        return value < lowerBound || upperBound < value;
    }

    private static boolean isOutsideLimits(final double value, final double lowerBound, final double upperBound)
    {
        return value < lowerBound || upperBound < value;
    }

    private static long signedValue(final boolean isNegative, final long value)
    {
        return isNegative ? -value : value;
    }

}
