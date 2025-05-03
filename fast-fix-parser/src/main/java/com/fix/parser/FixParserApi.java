package com.fix.parser;

import com.fix.decoder.Decoder;
import com.fix.decoder.NewOrderSingleDecoder;
import com.fix.exception.InvalidTagException;

public class FixParserApi {

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
