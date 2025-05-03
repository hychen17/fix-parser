package com.fix.parser;

import com.fix.decoder.NewOrderSingleDecoder;
import com.fix.exception.InvalidTagException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixParserApiTest {

    @Test
    void parseNewOrderSingle() throws InvalidTagException {
        // Test case for parsing a New Order Single message
        String fixMessage = "8=FIX.4.2\u00019=118\u000135=D\u000149=ONIXS\u000156=CME\u000134=2\u000152=20250501-09:20:52.111\u000111=983532-3\u000121=1\u000138=100\u000155=NVDA\u000140=2\u000144=135.5\u000154=1\u000160=20240501-09:20:52.004\u000110=017\u0001";

        FixParserApi fixParserApi = new FixParserApi();
        NewOrderSingleDecoder decoder = new NewOrderSingleDecoder();
        fixParserApi.parseNewOrderSingle(fixMessage.getBytes(), decoder);

        assertEquals("FIX.4.2", decoder.getHeader().beginStringAsString());
        assertEquals(118, decoder.getHeader().bodyLength());
        assertEquals("D", decoder.getHeader().msgTypeAsString());
        assertEquals("ONIXS", decoder.getHeader().senderCompIDAsString());
        assertEquals("CME", decoder.getHeader().targetCompIDAsString());
        assertEquals(2, decoder.getHeader().msgSeqNum());
        assertEquals("20250501-09:20:52.111", decoder.getHeader().sendingTimeAsString());
        assertEquals("983532-3", decoder.clOrdIDAsString());
        assertEquals("1", decoder.handlInstAsString());
        assertEquals(100.0, decoder.orderQty().toDouble());
        assertEquals("NVDA", decoder.symbolAsString());
        assertEquals("2", decoder.ordTypeAsString());
        assertEquals(135.5, decoder.price().toDouble());
        assertEquals("1", decoder.sideAsString());
        assertEquals("20240501-09:20:52.004", decoder.transactTimeAsString());
        assertEquals("017", decoder.getTrailer().checkSumAsString());

    }

}