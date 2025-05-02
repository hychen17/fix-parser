package com.fix.decoder;

import com.fix.constant.Constants;
import com.fix.exception.InvalidTagException;

import java.nio.ByteBuffer;

import static com.fix.constant.Constants.EQUAL_SIGN;
import static com.fix.constant.Constants.START_OF_HEADER;

public class TrailerDecoder implements Decoder {

    // CheckSum = 10
    private boolean hasChecksum;
    private char[] checkSum = new char[3];
    private int checkSumOffset;
    private int checkSumLength;

    public boolean hasChecksum() {
        return hasChecksum;
    }

    public char[] checkSum() {
        return checkSum;
    }

    public int checkSumLength() {
        return checkSumLength;
    }

    public String checkSumAsString()
    {
        return new String(checkSum, 0, checkSumLength);
    }

    private void resetChecksum() {
        hasChecksum = false;
        checkSumOffset = -1;
        checkSumLength = -1;
        for (int i = 0; i < checkSum.length; i++) {
            checkSum[i] = 0;
        }
    }

    public int decode(final byte[] fixMessageBytes,
                      final int startOffset) throws InvalidTagException {

        int end = fixMessageBytes.length;
        int tagPosition = startOffset;
        int positionIter = tagPosition;
        int tag;

        while (tagPosition < end) {
            final int equalsPosition = scan(fixMessageBytes, tagPosition, end, EQUAL_SIGN);

            tag = getInt(fixMessageBytes, tagPosition, equalsPosition);
            final int valueOffset = equalsPosition + 1;
            int endOfField = scan(fixMessageBytes, valueOffset, end, START_OF_HEADER);

            final int valueLength = endOfField - valueOffset;

            switch (tag) {
                case Constants.CHECK_SUM:
                    checkSum = getChars(fixMessageBytes, checkSum, valueOffset, valueLength);
                    checkSumOffset = valueOffset;
                    checkSumLength = valueLength;
                    break;

                default:
                    throw new InvalidTagException("Invalid tag in trailer: " + tag);

            }

            tagPosition = endOfField + 1;
        }
        return end;
    }

    @Override
    public void reset() {
        resetChecksum();
    }
}
