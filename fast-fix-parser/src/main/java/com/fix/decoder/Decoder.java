package com.fix.decoder;

import com.fix.exception.InvalidTagException;

/**
 * @author Tom Haoyuan Chen
 */
public interface Decoder {
    int decode(byte[] messageBytes, int offset) throws InvalidTagException;

    void reset();

    StringBuilder stringAppender();
}
