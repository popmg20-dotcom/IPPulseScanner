package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpdyHeaderBlockEncoder {
    public static SpdyHeaderBlockEncoder newInstance(SpdyVersion spdyVersion, int i, int i2, int i3) {
        return PlatformDependent.javaVersion() >= 7 ? new SpdyHeaderBlockZlibEncoder(spdyVersion, i) : new SpdyHeaderBlockJZlibEncoder(spdyVersion, i, i2, i3);
    }

    public abstract ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame);

    public abstract void end();
}
