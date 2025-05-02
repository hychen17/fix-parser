package com.fix.decoder;

import com.fix.exception.InvalidTagException;

import java.nio.ByteBuffer;

public interface Decoder {
    int decode(byte[] messageBytes, int offset) throws InvalidTagException;

    void reset();

    StringBuilder stringAppender();
}
