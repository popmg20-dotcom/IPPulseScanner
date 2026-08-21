package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface DnsRawRecord extends DnsRecord, ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    DnsRawRecord copy();

    @Override // io.netty.buffer.ByteBufHolder
    DnsRawRecord duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    DnsRawRecord replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    DnsRawRecord retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    DnsRawRecord retain(int i);

    @Override // io.netty.buffer.ByteBufHolder
    DnsRawRecord retainedDuplicate();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    DnsRawRecord touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    DnsRawRecord touch(Object obj);
}
