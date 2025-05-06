package com.fix.parser;

import com.fix.decoder.NewOrderSingleDecoder;
import com.fix.exception.InvalidTagException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixParserTest {

    private final static String ORIGNAL_FIX_MESSAGE = "8=FIX.4.2\u00019=118\u000135=D\u000149=ONIXS\u000156=CME\u000134=2\u000152=20250501-09:20:52.111\u000111=983532-3\u000121=1\u000138=100\u000155=NVDA\u000140=2\u000144=135.5802\u000154=1\u000160=20240501-09:20:52.004\u000110=017\u0001";

    private final static byte[] ORIGNAL_FIX_MESSAGE_BYTES = ORIGNAL_FIX_MESSAGE.getBytes();

    private final NewOrderSingleDecoder decoder = new NewOrderSingleDecoder();

    private final FixParser fixParser = new FixParser();

    @Test
    public void can_parse_a_newOrderSingle() throws InvalidTagException {
        fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);

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
        assertEquals(135.5802, decoder.price().toDouble());
        assertEquals("1", decoder.sideAsString());
        assertEquals("20240501-09:20:52.004", decoder.transactTimeAsString());
        assertEquals("017", decoder.getTrailer().checkSumAsString());
    }

    @Test
    public void can_parse_a_newOrderSingle_and_print_as_string() throws InvalidTagException {
        String newOrderSingleString = fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES);
        assertNotNull(newOrderSingleString);
        System.out.println(newOrderSingleString);
    }

    @Test
    public void benchmark_the_latency_of_parsing_1_000_000_newOrderSingle() throws InvalidTagException {
        long[] timeElapsed = new long[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            long startNs = System.nanoTime();
            fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);
            long stopNs = System.nanoTime();
            timeElapsed[i] = stopNs - startNs;
        }
    }

    @Test
    public void benchmark_the_latency_of_parsing_5_000_000_newOrderSingle() throws InvalidTagException {
        long[] timeElapsed = new long[5_000_000];
        for (int i = 0; i < 5_000_000; i++) {
            long startNs = System.nanoTime();
            fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);
            long stopNs = System.nanoTime();
            timeElapsed[i] = stopNs - startNs;
        }
    }

    @Test
    public void benchmark_the_latency_of_parsing_10_000_000_newOrderSingle() throws InvalidTagException {
        long[] timeElapsed = new long[10_000_000];
        for (int i = 0; i < 10_000_000; i++) {
            long startNs = System.nanoTime();
            fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);
            long stopNs = System.nanoTime();
            timeElapsed[i] = stopNs - startNs;
        }
    }

}