package com.fix.util.math;

public class MutableDecimalFloat extends DecimalFloat {

    public MutableDecimalFloat() {
        super();
    }

    public MutableDecimalFloat(DecimalFloat df) {
        this(df.getValue(), df.getScale());
    }

    public MutableDecimalFloat(final long value, final int scale) {
        super(value, scale);
    }

    public MutableDecimalFloat(final double dbl) {
        super();
        this.fromDouble(dbl);
    }

    public MutableDecimalFloat(final String str) {
        super();
        this.fromString(str);
    }

    public MutableDecimalFloat plus(ReadOnlyDecimalFloat other) {
        return plus(other, Math.max(this.getScale(), other.getScale()), RoundingMode.HALF_UP);
    }

    public MutableDecimalFloat plus(ReadOnlyDecimalFloat other, int decimalPlace) {
        return plus(other, decimalPlace, RoundingMode.HALF_UP);
    }

    public MutableDecimalFloat plus(ReadOnlyDecimalFloat other, int decimalPlace, RoundingMode roundingMode) {
        long thisValue = getValue();
        int thisScale = getScale();

        long otherValue = other.getValue();
        int otherScale = other.getScale();

        if (thisScale > otherScale) {
            otherValue = safeRaising(otherValue, thisScale - otherScale);
        } else {
            thisValue = safeRaising(thisValue, otherScale - thisScale);
        }

        if (safeToAdd(thisValue, otherValue)) {
            thisValue += otherValue;
        } else {
            throw new ArithmeticException("value " + thisValue + " overflow after add by " + otherValue);
        }

        int newScale = Math.min(Math.max(thisScale, otherScale), ReadOnlyDecimalFloat.SCALE_MAX_VAL);

        // rounding below
        if (newScale > decimalPlace) {
            thisValue = safeShrinking(thisValue, newScale - decimalPlace - 1);
            thisValue = doRound(thisValue, roundingMode);
        } else {
            thisValue = safeRaising(thisValue, decimalPlace - newScale);
        }

        this.setWithoutNormalisation(thisValue, decimalPlace);

        return this;
    }

    public MutableDecimalFloat minus(ReadOnlyDecimalFloat other) {
        return minus(other, Math.max(this.getScale(), other.getScale()), RoundingMode.HALF_UP);
    }

    public MutableDecimalFloat minus(ReadOnlyDecimalFloat other, int decimalPlace) {
        this.minus(other, decimalPlace, RoundingMode.HALF_UP);
        return this;
    }

    public MutableDecimalFloat minus(ReadOnlyDecimalFloat other, int decimalPlace, RoundingMode roundingMode) {
        long thisValue = getValue();
        int thisScale = getScale();

        long otherValue = other.getValue();
        int otherScale = other.getScale();

        if (thisScale > otherScale) {
            otherValue = safeRaising(otherValue, thisScale - otherScale);
        } else {
            thisValue = safeRaising(thisValue, otherScale - thisScale);
        }

        if (safeToAdd(thisValue, -otherValue)) {
            thisValue -= otherValue;
        } else {
            throw new ArithmeticException("value " + thisValue + " overflow after add by " + otherValue);
        }

        int newScale = Math.min(Math.max(thisScale, otherScale), ReadOnlyDecimalFloat.SCALE_MAX_VAL);

        // rounding below
        if (newScale > decimalPlace) {
            thisValue = safeShrinking(thisValue, newScale - decimalPlace - 1);
            thisValue = doRound(thisValue, roundingMode);
        } else {
            thisValue = safeRaising(thisValue, decimalPlace - newScale);
        }

        this.setWithoutNormalisation(thisValue, decimalPlace);

        return this;
    }

    public MutableDecimalFloat multiply(ReadOnlyDecimalFloat other) {
        return multiply(other, this.getScale() + other.getScale(), RoundingMode.HALF_UP);
    }

    public MutableDecimalFloat multiply(ReadOnlyDecimalFloat other, int decimalPlace) {
        return multiply(other, decimalPlace, RoundingMode.HALF_UP);
    }

    public MutableDecimalFloat multiply(ReadOnlyDecimalFloat other, int decimalPlace, RoundingMode roundingMode) {
        validateScale(decimalPlace);

        long thisValue = getValue();
        int thisScale = getScale();

        long otherValue = other.getValue();
        int otherScale = other.getScale();

        if (safeToMultiply(thisValue, otherValue)) {
            thisValue *= otherValue;
            thisScale = Math.min(thisScale + otherScale, ReadOnlyDecimalFloat.SCALE_MAX_VAL);
        } else {
            throw new ArithmeticException("value " + thisValue + " overflow after multiply by " + otherValue);
        }

        // rounding below
        if (thisScale > decimalPlace) {
            thisValue = safeShrinking(thisValue, thisScale - decimalPlace - 1);
            thisValue = doRound(thisValue, roundingMode);
        } else {
            thisValue = safeRaising(thisValue, decimalPlace - thisScale);
        }

        this.setWithoutNormalisation(thisValue, decimalPlace);

        return this;
    }

    public MutableDecimalFloat dividedBy(ReadOnlyDecimalFloat other) {
        return dividedBy(other, Math.max(this.getScale(), other.getScale()), RoundingMode.HALF_UP);
    }

    public MutableDecimalFloat dividedBy(ReadOnlyDecimalFloat other, int decimalPlace) {
        return dividedBy(other, decimalPlace, RoundingMode.HALF_UP);
    }

    public MutableDecimalFloat dividedBy(ReadOnlyDecimalFloat other, int decimalPlace, RoundingMode roundingMode) {
        validateDivision(other, decimalPlace);

        long thisValue = getValue();
        int thisScale = getScale();

        long otherValue = other.getValue();
        int otherScale = other.getScale();

        if (decimalPlace + otherScale >= thisScale) {
            int raise = (decimalPlace + otherScale) - thisScale + 1;
            thisValue = safeRaising(thisValue, raise);
        } else {
            int shrink = (thisScale - decimalPlace) - otherScale - 1;
            thisValue = safeShrinking(thisValue, shrink);
        }

        thisValue /= otherValue;

        thisValue = doRound(thisValue, roundingMode);

        setWithoutNormalisation(thisValue, decimalPlace);
        return this;
    }

    private void validateDivision(ReadOnlyDecimalFloat other, int decimalPlace) {
        if (other.getValue() == 0) {
            throw new ArithmeticException("divisor cannot be 0");
        }

        validateScale(decimalPlace);
    }

    private void validateScale(int decimalPlace) {
        if (decimalPlace < ReadOnlyDecimalFloat.SCALE_MIN_VAL || decimalPlace > ReadOnlyDecimalFloat.SCALE_MAX_VAL) {
            throw new ArithmeticException("decimalPlaces must be greater than " + ReadOnlyDecimalFloat.SCALE_MIN_VAL +
                    " and less than " + ReadOnlyDecimalFloat.SCALE_MAX_VAL);
        }
    }

    private boolean safeToMultiply(long thisValue, long otherValue) {
        return Math.abs(thisValue) < ReadOnlyDecimalFloat.VALUE_MAX_VAL / Math.abs(otherValue) + 1;
    }

    private boolean safeToAdd(long thisValue, long otherValue) {
        return Math.abs(thisValue) < ReadOnlyDecimalFloat.VALUE_MAX_VAL - Math.abs(otherValue);
    }

    private long safeRaising(long value, int raise) {
        if (ReadOnlyDecimalFloat.VALUE_MAX_VAL / PowerOf10.pow10(raise) < value ||
                ReadOnlyDecimalFloat.VALUE_MIN_VAL / PowerOf10.pow10(raise) > value) {
            throw new ArithmeticException("value " + value + " overflow after raise by 10 to the power of " + raise);
        }
        return value * PowerOf10.pow10(raise);
    }

    private long safeShrinking(long value, int shrink) {
        return value / PowerOf10.pow10(shrink);
    }

    private long doRound(long thisValue, RoundingMode roundingMode) {
        if (roundingMode == RoundingMode.HALF_UP) {
            if (Math.abs(thisValue) % 10 >= 5) {
                thisValue = thisValue > 0 ? thisValue + 10 : thisValue - 10;
            }
        }
        if (roundingMode == RoundingMode.FLOOR) {
            if (thisValue < 0) {
                thisValue = thisValue - 10;
            }
        }
        if (roundingMode == RoundingMode.CEILING) {
            if (thisValue > 0) {
                thisValue = thisValue + 10;
            }
        }
        return thisValue / 10;
    }

    public MutableDecimalFloat round(int decimalPlace, RoundingMode roundingMode) {
        long thisValue = getValue();
        int thisScale = getScale();

        // rounding below
        if (thisScale > decimalPlace) {
            thisValue = safeShrinking(thisValue, thisScale - decimalPlace - 1);
            thisValue = doRound(thisValue, roundingMode);
        } else {
            thisValue = safeRaising(thisValue, decimalPlace - thisScale);
        }

        this.setWithoutNormalisation(thisValue, decimalPlace);

        return this;
    }

    public MutableDecimalFloat floor() {
        return round(0, RoundingMode.FLOOR);
    }

    public MutableDecimalFloat ceil() {
        return round(0, RoundingMode.CEILING);
    }

    public enum RoundingMode {
        HALF_UP,
        FLOOR,
        CEILING
    }
}
