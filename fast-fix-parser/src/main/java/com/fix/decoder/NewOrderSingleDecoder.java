package com.fix.decoder;

import com.fix.constant.Constants;
import com.fix.exception.InvalidTagException;
import com.fix.util.math.MutableDecimalFloat;

import static com.fix.constant.Constants.*;
import static com.fix.util.bytes.BytesScanner.*;

/**
 * Only include the mandatory fields in this example.
 * The non-mandatory fields should follow the same paradigm and created automatically by a code-gen template.
 *
 * @author Tom Haoyuan Chen
 */
public class NewOrderSingleDecoder implements Decoder{

    private final HeaderDecoder headerDecoder = new HeaderDecoder();

    private final TrailerDecoder trailerDecoder = new TrailerDecoder();

    public HeaderDecoder getHeader() {
        return headerDecoder;
    }

    public TrailerDecoder getTrailer() {
        return trailerDecoder;
    }

    /* ClOrdID = 11 */
    private boolean hasClOrdID;
    private char[] clOrdID = new char[1];
    private int clOrdIDLength;

    public char[] clOrdID() {
        return clOrdID;
    }

    public boolean hasClOrdID() {
        return hasClOrdID;
    }

    public int clOrdIDLength() {
        return clOrdIDLength;
    }

    public String clOrdIDAsString() {
        return new String(clOrdID, 0, clOrdIDLength);
    }

    public void resetClOrdID() {
        hasClOrdID = false;
        clOrdIDLength = -1;
        for (int i = 0; i < clOrdID.length; i++) {
            clOrdID[i] = 0;
        }
    }

    /* HandlInst = 21 */
    private boolean hasHandlInst;
    private char handlInst = (char) 0;

    public boolean hasHandlInst() {
        return hasHandlInst;
    }

    public char handlInst() {
        return handlInst;
    }

    public String handlInstAsString() {
        return String.valueOf(handlInst);
    }

    public void resetHandlInst() {
        hasHandlInst = false;
        handlInst = (char) 0;
    }

    /* Symbol = 55 */
    private boolean hasSymbol;
    private char[] symbol = new char[1];
    private int symbolLength;

    public boolean hasSymbol() {
        return hasSymbol;
    }

    public char[] symbol() {
        return symbol;
    }

    public int symbolLength() {
        return symbolLength;
    }

    public String symbolAsString() {
        return new String(symbol, 0, symbolLength);
    }

    public void resetSymbol() {
        hasSymbol = false;
        symbolLength = -1;
        for (int i = 0; i < symbol.length; i++) {
            symbol[i] = 0;
        }
    }

    /* Side = 54 */
    private boolean hasSide;
    private char side = (char) 0;

    public boolean hasSide() {
        return hasSide;
    }

    public char side() {
        return side;
    }

    public void resetSide() {
        hasSide = false;
        side = (char) 0;
    }

    public String sideAsString() {
        return String.valueOf(side);
    }

    /* TransactTime = 60 */
    private boolean hasTransactTime;
    private char[] transactTime = new char[27];
    private int transactTimeLength = -1;

    public boolean hasTransactTime() {
        return hasTransactTime;
    }

    public char[] transactTime() {
        return transactTime;
    }

    public int transactTimeLength() {
        return transactTimeLength;
    }

    public String transactTimeAsString() {
        return new String(transactTime, 0, transactTimeLength);
    }

    public void resetTransactTime() {
        hasTransactTime = false;
        transactTimeLength = -1;
        for (int i = 0; i < transactTime.length; i++) {
            transactTime[i] = 0;
        }
    }

    /* OrdType = 40 */
    private boolean hasOrdType;
    private char ordType = (char) 0;

    public boolean hasOrdType() {
        return hasOrdType;
    }

    public char ordType() {
        return ordType;
    }

    public void resetOrdType() {
        hasOrdType = false;
        ordType = (char) 0;
    }

    public String ordTypeAsString() {
        return String.valueOf(ordType);
    }

    /* Price = 44 */
    private boolean hasPrice;
    private MutableDecimalFloat price = new MutableDecimalFloat();

    public boolean hasPrice() {
        return hasPrice;
    }

    public MutableDecimalFloat price() {
        return price;
    }

    public void resetPrice() {
        hasPrice = false;
        price.set(0, 0);
    }

    /* OrderQty = 38 */
    private boolean hasOrderQty;
    private MutableDecimalFloat orderQty = new MutableDecimalFloat();

    public boolean hasOrderQty() {
        return hasOrderQty;
    }

    public MutableDecimalFloat orderQty() {
        return orderQty;
    }

    public void resetOrderQty() {
        hasOrderQty = false;
        orderQty.set(0, 0);
    }

    public int decode(byte[] messageBytes) throws InvalidTagException {
        return decode(messageBytes, 0);
    }

    @Override
    public int decode(byte[] messageBytes, int offset) throws InvalidTagException {
        int bodyOffset = headerDecoder.decode(messageBytes, offset);

        int trailerOffset = decodeMsgBody(messageBytes, bodyOffset);

        int decodedLength = trailerDecoder.decode(messageBytes, trailerOffset);
        return decodedLength;
    }

    @Override
    public void reset() {
        headerDecoder.reset();
        trailerDecoder.reset();
        resetClOrdID();
        resetHandlInst();
        resetSymbol();
        resetSide();
        resetTransactTime();
        resetOrdType();
        resetPrice();
        resetOrderQty();
    }

    private int decodeMsgBody(byte[] fixMessageBytes, int bodyOffset) {
        int end = fixMessageBytes.length;
        int tagPosition = bodyOffset;
        int tag;

        while (tagPosition < end) {
            final int equalsPosition = scan(fixMessageBytes, tagPosition, end, EQUAL_SIGN);
            tag = getInt(fixMessageBytes, tagPosition, equalsPosition);
            final int valueOffset = equalsPosition + 1;
            final int endOfValue = scan(fixMessageBytes, valueOffset, end, START_OF_HEADER);
            final int valueLength = endOfValue - valueOffset;

            switch (tag) {
                case Constants.CL_ORD_ID:
                    clOrdID = getChars(fixMessageBytes, clOrdID, valueOffset, endOfValue);
                    hasClOrdID = true;
                    clOrdIDLength = valueLength;
                    break;
                case Constants.HANDL_INST:
                    handlInst = getChar(fixMessageBytes, valueOffset);
                    hasHandlInst = true;
                    break;
                case Constants.SYMBOL:
                    symbol = getChars(fixMessageBytes, symbol, valueOffset, endOfValue);
                    hasSymbol = true;
                    symbolLength = valueLength;
                    break;
                case Constants.SIDE:
                    side = getChar(fixMessageBytes, valueOffset);
                    hasSide = true;
                    break;
                case Constants.TRANSACT_TIME:
                    transactTime = getChars(fixMessageBytes, transactTime, valueOffset, endOfValue);
                    hasTransactTime = true;
                    transactTimeLength = valueLength;
                    break;
                case Constants.ORD_TYPE:
                    ordType = getChar(fixMessageBytes, valueOffset);
                    hasOrdType = true;
                    break;
                case Constants.PRICE:
                    price.fromString(getString(fixMessageBytes, valueOffset, endOfValue));
                    hasPrice = true;
                    break;
                case Constants.ORDER_QTY:
                    orderQty.fromString(getString(fixMessageBytes, valueOffset, endOfValue));
                    hasOrderQty = true;
                    break;

                default:
                    // will return when the tagPosition hit the first tag of the trailer
                    // TODO: handle unknown tag
                    return tagPosition;
            }
            tagPosition = endOfValue + 1;
        }

        return tagPosition;
    }

    @Override
    public StringBuilder stringAppender() {
        StringBuilder sb = new StringBuilder();
        sb.append(headerDecoder.stringAppender());
        if (hasClOrdID()) {
            sb.append(CL_ORD_ID + "=").append(clOrdIDAsString()).append((char) START_OF_HEADER);
        }
        if (hasHandlInst()) {
            sb.append(HANDL_INST + "=").append(handlInst()).append((char) START_OF_HEADER);
        }
        if (hasSymbol()) {
            sb.append(SYMBOL + "=").append(symbolAsString()).append((char) START_OF_HEADER);
        }
        if (hasSide()) {
            sb.append(SIDE + "=").append(side()).append((char) START_OF_HEADER);
        }
        if (hasTransactTime()) {
            sb.append(TRANSACT_TIME + "=").append(transactTimeAsString()).append((char) START_OF_HEADER);
        }
        if (hasOrdType()) {
            sb.append(ORD_TYPE + "=").append(ordType()).append((char) START_OF_HEADER);
        }
        if (hasPrice()) {
            sb.append(PRICE + "=").append(price().toString()).append((char) START_OF_HEADER);
        }
        if (hasOrderQty()) {
            sb.append(ORDER_QTY + "=").append(orderQty().toString()).append((char) START_OF_HEADER);
        }
        sb.append(trailerDecoder.stringAppender());
        return sb;
    }
}
