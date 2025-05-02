package com.fix.parser;

import com.fix.decoder.Decoder;
import com.fix.decoder.NewOrderSingleDecoder;
import com.fix.exception.InvalidTagException;

public class FixParserApi {

    public void parseNewOrderSingle(byte[] fixMessage, NewOrderSingleDecoder newOrderSingleDecoder) throws InvalidTagException {
        newOrderSingleDecoder.reset();
        newOrderSingleDecoder.decode(fixMessage);
    }

    public String parseNewOrderSingle(byte[] fixMessage) {
        NewOrderSingleDecoder newOrderSingleDecoder = new NewOrderSingleDecoder();
        return newOrderSingleDecoder.stringAppender().toString();

    }
}
