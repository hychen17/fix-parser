package com.fix.parser;

import com.fix.decoder.NewOrderSingleDecoder;
import com.fix.exception.InvalidTagException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    /**
     * The 99.00000 percentile is: 1261 ns
     * The 99.90000 percentile is: 4470 ns
     * The 99.99000 percentile is: 34456 ns
     * The 99.99990 percentile is: 308373 ns
     */
    public void benchmark_the_latency_of_parsing_1_000_000_newOrderSingle() throws InvalidTagException {
        long[] timeElapsed = new long[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            long startNs = System.nanoTime();
            fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);
            long stopNs = System.nanoTime();
            timeElapsed[i] = stopNs - startNs;
        }

        Arrays.sort(timeElapsed);
        double[] percentiles = {99, 99.9, 99.99, 99.9999};
        for (double percentile : percentiles) {
            int index = (int) Math.ceil(percentile / 100 * timeElapsed.length) - 1;
            System.out.printf("The %.5f percentile is: %d ns%n", percentile, timeElapsed[index]);
        }
    }

    @Test
    /**
     * The 99.00000 percentile is: 725 ns
     * The 99.90000 percentile is: 1465 ns
     * The 99.99000 percentile is: 35320 ns
     * The 99.99990 percentile is: 275354 ns
     */
    public void benchmark_the_latency_of_parsing_5_000_000_newOrderSingle() throws InvalidTagException {
        long[] timeElapsed = new long[5_000_000];
        for (int i = 0; i < 5_000_000; i++) {
            long startNs = System.nanoTime();
            fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);
            long stopNs = System.nanoTime();
            timeElapsed[i] = stopNs - startNs;
        }

        Arrays.sort(timeElapsed);
        double[] percentiles = {99, 99.9, 99.99, 99.9999};
        for (double percentile : percentiles) {
            int index = (int) Math.ceil(percentile / 100 * timeElapsed.length) - 1;
            System.out.printf("The %.5f percentile is: %d ns%n", percentile, timeElapsed[index]);
        }
    }

    @Test
    /**
     * The 99.00000 percentile is: 434 ns
     * The 99.90000 percentile is: 1303 ns
     * The 99.99000 percentile is: 37824 ns
     * The 99.99990 percentile is: 136124 ns
     */
    public void benchmark_the_latency_of_parsing_20_000_000_newOrderSingle() throws InvalidTagException {
        long[] timeElapsed = new long[20_000_000];
        for (int i = 0; i < 20_000_000; i++) {
            long startNs = System.nanoTime();
            fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);
            long stopNs = System.nanoTime();
            timeElapsed[i] = stopNs - startNs;
        }

        Arrays.sort(timeElapsed);
        double[] percentiles = {99, 99.9, 99.99, 99.9999};
        for (double percentile : percentiles) {
            int index = (int) Math.ceil(percentile / 100 * timeElapsed.length) - 1;
            System.out.printf("The %.5f percentile is: %d ns%n", percentile, timeElapsed[index]);
        }
    }

    @Test
    public void benchmark_the_memory_allocation_of_parsing_1_000_000_newOrderSingle() throws InvalidTagException {
        for (int i = 0; i < 1_000_000; i++) {
            fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);
        }
    }

    @Test
    public void benchmark_the_memory_allocation_of_parsing_5_000_000_newOrderSingle() throws InvalidTagException {
        for (int i = 0; i < 5_000_000; i++) {
            fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);
        }
    }

    @Test
    public void benchmark_the_memory_allocation_of_parsing_20_000_000_newOrderSingle() throws InvalidTagException {
        for (int i = 0; i < 20_000_000; i++) {
            fixParser.parseNewOrderSingle(ORIGNAL_FIX_MESSAGE_BYTES, decoder);
        }
    }

}