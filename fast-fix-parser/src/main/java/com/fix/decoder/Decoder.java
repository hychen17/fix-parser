package com.fix.decoder;

import com.fix.exception.InvalidTagException;

/**
 * @author Tom Haoyuan Chen
 */
public interface Decoder {
    /**
     * Decode a message.
     *
     * @param messageBytes the byte array of the message
     * @return the number of bytes consumed
     * @throws InvalidTagException if an invalid tag is encountered
     */
    int decode(byte[] messageBytes, int offset) throws InvalidTagException;

    void reset();

    StringBuilder stringAppender();
}
