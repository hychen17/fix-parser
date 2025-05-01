package com.fix.decoder;

import java.nio.ByteBuffer;

public interface Decoder {
    int decode(ByteBuffer buffer, int offset, int length);

    void reset();
}
