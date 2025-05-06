package com.fix.parser;

import com.fix.decoder.NewOrderSingleDecoder;
import com.fix.exception.InvalidTagException;

/**
 *
 * For illustrating purpose, only NewOrderSingle is included here as an example.
 * Parsers for other types of FIX message will be following the same paradigm.
 *
 * @author Tom Haoyuan Chen
 */
public class FixParser {

    public void parseNewOrderSingle(byte[] fixMessage, NewOrderSingleDecoder newOrderSingleDecoder) throws InvalidTagException {
        newOrderSingleDecoder.reset();
        newOrderSingleDecoder.decode(fixMessage);
    }

    public String parseNewOrderSingle(byte[] fixMessage) throws InvalidTagException {
        NewOrderSingleDecoder newOrderSingleDecoder = new NewOrderSingleDecoder();
        newOrderSingleDecoder.decode(fixMessage);
        return newOrderSingleDecoder.stringAppender().toString();
    }
}
