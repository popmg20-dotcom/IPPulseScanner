package io.netty.handler.stream;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface ChunkedInput<B> {
    void close();

    boolean isEndOfInput();

    long length();

    long progress();

    B readChunk(ByteBufAllocator byteBufAllocator);

    @Deprecated
    B readChunk(ChannelHandlerContext channelHandlerContext);
}
