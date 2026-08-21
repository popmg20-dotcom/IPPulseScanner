package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface SpdyDataFrame extends ByteBufHolder, SpdyStreamFrame {
    @Override // io.netty.buffer.ByteBufHolder
    ByteBuf content();

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame copy();

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame retain(int i);

    @Override // io.netty.buffer.ByteBufHolder
    SpdyDataFrame retainedDuplicate();

    SpdyDataFrame setLast(boolean z);

    SpdyDataFrame setStreamId(int i);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    SpdyDataFrame touch(Object obj);
}
