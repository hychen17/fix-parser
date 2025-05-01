package com.fix.decoder;

import java.nio.ByteBuffer;

public interface FIXMessageDecoder {

    HeaderDecoder header();

    TrailerDecoder trailer();


}
